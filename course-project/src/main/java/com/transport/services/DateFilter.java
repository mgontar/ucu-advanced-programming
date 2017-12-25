package com.transport.services;

import com.transport.bl.DrivePoint;
import org.apache.spark.api.java.JavaRDD;

import java.util.Date;

public interface DateFilter {
    JavaRDD<DrivePoint> filterDate(JavaRDD<DrivePoint> drivePoints, Date date);
}
