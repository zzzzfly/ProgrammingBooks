package com.fyzheng.chapter3;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author fyzheng
 * @create 2021-08-21 22:26
 * @Description:
 */
public class VehicleTracker {
    private Map<String, Location> locMap = new ConcurrentHashMap<String, Location>();

    public void updateLocation(String vehicleId, Location newlocation) {
        locMap.put(vehicleId, newlocation);
    }
}
