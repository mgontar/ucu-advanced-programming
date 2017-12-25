package com.transport.validators;

import com.transport.bl.Vehicle;
import org.springframework.stereotype.Service;

@Service
public class VehicleValidatorImpl implements VehicleValidator {
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
