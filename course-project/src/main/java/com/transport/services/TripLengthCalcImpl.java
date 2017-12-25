package com.transport.services;

import com.transport.bl.DrivePoint;
import com.transport.broadcast.AutowiredBroadcast;
import com.transport.config.UserConfig;
import com.transport.utils.GeoUtils;
import lombok.SneakyThrows;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.spark.api.java.JavaDoubleRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.broadcast.Broadcast;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class TripLengthCalcImpl implements TripLengthCalc, Serializable {

    @Override
    @SneakyThrows
    public double calcTripLength(JavaRDD<DrivePoint> tripPoints) {
        JavaDoubleRDD doubleRDD = tripPoints
                .mapToDouble(p -> GeoUtils.distance(p.getLatStart(), p.getLonStart(),p.getLatEnd(), p.getLonEnd()));
        return doubleRDD.sum();
    }
}