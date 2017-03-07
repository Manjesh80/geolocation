package com.manjesh.microservices.repository;

import com.manjesh.microservices.model.GeoLocation;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 3/7/2017.
 */

@Repository
public class GeoLocationRepository {

    private List<GeoLocation> geolocations = new
            ArrayList<GeoLocation>();

    public void addGeoLocation(GeoLocation geolocation) {
        geolocations.add(geolocation);
    }

    public List<GeoLocation> getGeoLocations() {
        return Collections.unmodifiableList(geolocations);
    }
}
