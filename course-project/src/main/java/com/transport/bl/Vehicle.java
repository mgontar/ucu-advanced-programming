package com.transport.bl;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Vehicle implements Serializable {
    private int vehicleId;
    private int routeId;
    private String vehicleCode;
    private boolean hasLowFloor;
}
