package com.transport.services;

import com.transport.bl.DrivePoint;
import com.transport.broadcast.AutowiredBroadcast;
import com.transport.config.UserConfig;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.broadcast.Broadcast;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TripFilterImpl implements TripFilter {

    @AutowiredBroadcast
    private Broadcast<UserConfig> broadcast;

    @Override
    public JavaRDD<DrivePoint> filterTrip(JavaRDD<DrivePoint> drivePoints) {
        JavaRDD<DrivePoint> datePoints = drivePoints.filter(dp -> diffMinutes(dp) < broadcast.getValue().getTripSplitTimeMinutes());
        return datePoints;
    }

    private long diffMinutes(DrivePoint dp)
    {
        long diff = dp.getDateEnd().getTime() - dp.getDateStart().getTime();
        long minutes = TimeUnit.MILLISECONDS.toMinutes(diff);
        return minutes;
    }
}
