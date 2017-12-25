package com.transport.bl;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Setter
@Getter
public class DrivePoint implements Serializable {

    private int routeId;
    private int vehicleId;
    private Date dateStart;
    private double latStart;
    private double lonStart;
    private Date dateEnd;
    private double latEnd;
    private double lonEnd;

    static final SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public DrivePoint(String string) throws ParseException {
        String regExStr = "^route_id=(.+?);vehicle_id=(.+?);time_start=(.+?);lon_start=(.+?);lat_start=(.+?);time_end=(.+?);lon_end=(.+?);lat_end=(.+?)$";
        Pattern pattern = Pattern.compile(regExStr);
        Matcher matcher = pattern.matcher(string);
        matcher.find();
        this.routeId = Integer.valueOf(matcher.group(1));
        this.vehicleId = Integer.valueOf(matcher.group(2));

        this.dateStart = DrivePoint.dateFormatter.parse(matcher.group(3));
        this.lonStart = Double.valueOf(matcher.group(4));
        this.latStart = Double.valueOf(matcher.group(5));

        this.dateEnd = DrivePoint.dateFormatter.parse(matcher.group(6));
        this.lonEnd = Double.valueOf(matcher.group(7));
        this.latEnd = Double.valueOf(matcher.group(8));
    }
}
