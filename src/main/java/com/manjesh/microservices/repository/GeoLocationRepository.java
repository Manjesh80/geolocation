package com.manjesh.microservices.repository;

import com.manjesh.microservices.model.GeoLocation;
import org.springframework.stereotype.Repository;

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

    public void addGeoLocation(GeoLocation geolocation) {
        geolocations.add(geolocation);
    }

    public List<GeoLocation> getGeoLocations() {
        return Collections.unmodifiableList(geolocations);
    }
}
