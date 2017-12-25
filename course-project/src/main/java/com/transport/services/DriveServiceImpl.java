package com.transport.services;

import com.transport.bl.DrivePoint;
import com.transport.validators.DrivePointValidator;
import lombok.SneakyThrows;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Date;

import static org.apache.spark.storage.StorageLevel.MEMORY_AND_DISK;

@Service
public class DriveServiceImpl implements DriveService, Serializable {

    @Autowired
    private transient JavaSparkContext sc;

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
        /*
        JavaRDD<DrivePoint> validDrivePoints = drivePoints.filter(dp -> dpValidator.validate(dp));
        JavaRDD<DrivePoint> vehiclePoints = vehicleFilter.filterVehicle(validDrivePoints, vehicleCode);
        JavaRDD<DrivePoint> vehicleDatePoints = dateFilter.filterDate(vehiclePoints, date);
        JavaRDD<DrivePoint> tripPoints = tripFilter.filterTrip(vehicleDatePoints);
        */
       double tripLength = tripLengthCalc.calcTripLength(drivePoints);
       return tripLength;
    }
}
