package com.manjesh.microservices.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.manjesh.microservices.model.GeoLocation;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 3/7/2017.
 */

@Repository
public class GeoLocationRepository {

    private List<GeoLocation> geolocations = new
            ArrayList<GeoLocation>();

    public GeoLocationRepository() {
        geolocations.add(
                new GeoLocation(1, 2, UUID.randomUUID(), System.currentTimeMillis()));
    }

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final String DATA_FILES_DIR =
            System.getenv("GEOLOCATION_DATA_FILES_DIR") != null ?
                    System.getenv("GEOLOCATION_DATA_FILES_DIR") :
                    "/opt/ganesh/geolocation/data";

    public void addGeoLocation(GeoLocation geolocation) {
        geolocations.add(geolocation);
        try {
            MAPPER.writeValue(new File(DATA_FILES_DIR + "/user" + geolocation.getUserId() + "_t" +
                    geolocation.getTimestamp()), geolocation);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<GeoLocation> getGeoLocations() {
        return Collections.unmodifiableList(geolocations);
    }
}
