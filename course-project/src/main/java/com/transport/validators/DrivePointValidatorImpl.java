package com.transport.validators;

import com.transport.bl.DrivePoint;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Date;

@Service
public class DrivePointValidatorImpl implements DrivePointValidator, Serializable {

    @Override
    public boolean validate(DrivePoint drivePoint){
        boolean result = true;
        if (drivePoint.getVehicleId() < 0) {
            result = false;
        } else if (drivePoint.getRouteId() < 0) {
            result = false;
        } else if (drivePoint.getDateStart().after(new Date())) {
            result = false;
        }else if (Math.abs(drivePoint.getLonStart()) > 180) {
            result = false;
        }else if (Math.abs(drivePoint.getLatStart()) > 90) {
            result = false;
        } else if (drivePoint.getDateEnd().after(new Date())) {
            result = false;
        }else if (Math.abs(drivePoint.getLonEnd()) > 180) {
            result = false;
        }else if (Math.abs(drivePoint.getLatEnd()) > 90) {
            result = false;
        }
        return result;
    }
}
