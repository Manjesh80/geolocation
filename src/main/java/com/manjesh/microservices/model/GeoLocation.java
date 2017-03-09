package com.manjesh.microservices.model;

import java.io.Serializable;
import java.util.UUID;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 3/7/2017.
 */
public class GeoLocation implements Serializable {

    private static final long serialVersionUID = 1L;

    private double latitude;
    private double longitude;

    public GeoLocation(double latitude, double longitude, UUID userId, long timestamp) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.userId = userId;
        this.timestamp = timestamp;
    }

    public GeoLocation() {

    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    private UUID userId;
    private long timestamp;

}
