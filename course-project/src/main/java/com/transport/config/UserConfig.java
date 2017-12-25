package com.transport.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class UserConfig implements Serializable{
    private int tripSplitTimeMinutes;

    @Value("${tripSplitTimeMinutes}")
    private void setTripSplitTimeMinutes(int tripSplitTimeMinutes) {
        this.tripSplitTimeMinutes = tripSplitTimeMinutes;
    }

    public int getTripSplitTimeMinutes() {
        return tripSplitTimeMinutes;
    }
}
