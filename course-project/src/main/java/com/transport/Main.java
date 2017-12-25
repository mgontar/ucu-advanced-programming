package com.transport;

import com.transport.constants.AppRunProfile;
import com.transport.services.DriveService;
import lombok.SneakyThrows;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.springframework.core.env.AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        System.setProperty(ACTIVE_PROFILES_PROPERTY_NAME, AppRunProfile.DEV);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Conf.class);
        DriveService driveService = context.getBean(DriveService.class);
        String vehicleCode = "ВС 7284 СО";
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormatter.parse("2017-07-20");

        double avgTripLength = driveService.sumTripLength(vehicleCode, date);
        System.out.println("com.transport.bl.Vehicle " + vehicleCode + " average trip length is "+avgTripLength+" km");

    }
}
