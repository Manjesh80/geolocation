package com.manjesh.microservices.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.springframework.beans.factory.annotation.Required;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 3/7/2017.
 */
@Entity
public class GeoLocation extends BaseModel {

    public String getRowKey() {
        return rowKey;
    }

    public void setRowKey(String rowKey) {
        this.rowKey = rowKey;
    }

    @Id
    @NotNull
    public String rowKey;
    private static final long serialVersionUID = 1L;
    private double latitude;
    private double longitude;
    private String ip;
    private UUID userId;
    private long timestamp;

    public GeoLocation(double latitude, double longitude, UUID userId, long timestamp) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.userId = userId;
        this.timestamp = timestamp;
        this.ip = getHostIp();
    }

    private String getHostIp() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            System.err.println("Error while finding local IP. Using localhost for now. Details: " + e.getMessage());
            e.printStackTrace();
            return "localhost";
        }
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

    public void alternateSetUserId(UUID userId) {
        this.userId = userId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
