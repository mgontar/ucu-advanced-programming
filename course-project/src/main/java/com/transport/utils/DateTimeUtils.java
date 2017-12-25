package com.transport.utils;

import com.transport.bl.DrivePoint;

import java.util.concurrent.TimeUnit;

public class DateTimeUtils {
    public static long diffMinutes(DrivePoint dp)
    {
        long diff = dp.getDateEnd().getTime() - dp.getDateStart().getTime();
        long minutes = TimeUnit.MILLISECONDS.toMinutes(diff);
        return minutes;
    }
}
