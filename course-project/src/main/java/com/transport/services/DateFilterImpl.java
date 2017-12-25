package com.transport.services;

import com.transport.bl.DrivePoint;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Date;

@Service
public class DateFilterImpl implements DateFilter, Serializable {

    @Override
    public JavaRDD<DrivePoint> filterDate(JavaRDD<DrivePoint> drivePoints, Date date) {
        JavaRDD<DrivePoint> datePoints = drivePoints.filter(dp -> DateUtils.isSameDay(dp.getDateStart(), date));
        return datePoints;
    }
}
