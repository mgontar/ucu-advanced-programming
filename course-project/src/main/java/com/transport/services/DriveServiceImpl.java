package com.transport.services;

import com.transport.bl.DrivePoint;
import com.transport.validators.DrivePointValidator;
import lombok.SneakyThrows;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

import static org.apache.spark.storage.StorageLevel.MEMORY_AND_DISK;

@Service
public class DriveServiceImpl implements DriveService {

    @Autowired
    private JavaSparkContext sc;

    @Autowired
    private VehicleFilter vehicleFilter;

    @Autowired
    private DateFilter dateFilter;

    @Autowired
    private TripFilter tripFilter;

    @Autowired
    private TripLengthCalc tripLengthCalc;

    @Autowired
    private DrivePointValidator dpValidator;

    @Override
    public double sumTripLength(String vehicleCode, Date date) {
        JavaRDD<String> rdd = sc.textFile("data/raw_data.txt");
        JavaRDD<DrivePoint> drivePoints = rdd.map(DrivePoint::new);
        JavaRDD<DrivePoint> validDrivePoints = drivePoints.filter(dp -> dp.getRouteId() > 0);
//        validDrivePoints.persist(MEMORY_AND_DISK());


        JavaRDD<DrivePoint> vehiclePoints = vehicleFilter.filterVehicle(validDrivePoints, vehicleCode);
/*
        System.out.println(vehiclePoints);
        vehiclePoints.persist(MEMORY_AND_DISK());

        JavaRDD<DrivePoint> vehicleDatePoints = dateFilter.filterDate(vehiclePoints, date);
        System.out.println(vehicleDatePoints);
        vehicleDatePoints.persist(MEMORY_AND_DISK());

        JavaRDD<DrivePoint> tripPoints = tripFilter.filterTrip(vehicleDatePoints);
        System.out.println(tripPoints);
        tripPoints.persist(MEMORY_AND_DISK());
*/
       double tripLength = tripLengthCalc.calcTripLength(vehiclePoints);
       return tripLength;
    }
}
