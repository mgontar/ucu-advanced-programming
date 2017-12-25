package com.transport.services;

import com.transport.bl.DrivePoint;
import org.apache.spark.api.java.JavaRDD;

public interface VehicleFilter {
    JavaRDD<DrivePoint> filterVehicle(JavaRDD<DrivePoint> drivePoints, String vehicleCode);
}
