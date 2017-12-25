package com.transport.services;

import com.transport.bl.DrivePoint;
import org.apache.spark.api.java.JavaRDD;

public interface TripFilter {
    JavaRDD<DrivePoint> filterTrip(JavaRDD<DrivePoint> drivePoints);
}
