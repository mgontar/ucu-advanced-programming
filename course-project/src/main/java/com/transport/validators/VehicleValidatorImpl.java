package com.transport.validators;

import com.transport.bl.Vehicle;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class VehicleValidatorImpl implements VehicleValidator, Serializable {
    @Override
    public boolean validate(Vehicle vehicle) {
        boolean result = true;
        if (vehicle.getVehicleId() < 0) {
            result = false;
        } else if (vehicle.getRouteId() < 0) {
            result = false;
        } else if (vehicle.getVehicleCode().isEmpty()) {
            result = false;
        }
        return result;
    }
}
