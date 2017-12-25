package com.transport.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.transport.bl.DrivePoint;
import com.transport.bl.Vehicle;
import com.transport.validators.VehicleValidator;
import lombok.SneakyThrows;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleFilterImpl implements VehicleFilter, Serializable {

    @Autowired
    private VehicleValidator vehicleValidator;

    @Override
    @SneakyThrows
    public JavaRDD<DrivePoint> filterVehicle(JavaRDD<DrivePoint> drivePoints, String vehicleCode) {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicles = mapper.readValue(new File("data/vehicles.json"), new TypeReference<List<Vehicle>>(){});
        List<Vehicle> validVehicles = vehicles.stream().filter(v -> vehicleValidator.validate(v)).collect(Collectors.toList());
        Vehicle vehicle = validVehicles.stream().filter(v -> v.getVehicleCode().equalsIgnoreCase(vehicleCode)).findFirst().get();
        JavaRDD<DrivePoint> vehicleDrivePoints = drivePoints.filter(drivePoint -> drivePoint.getVehicleId() == vehicle.getVehicleId());
        return  vehicleDrivePoints;
    }
}
