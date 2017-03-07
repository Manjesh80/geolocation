package com.manjesh.microservices.services;

import com.manjesh.microservices.model.GeoLocation;

import java.util.List;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 3/7/2017.
 */
public interface GeoLocationService {

    GeoLocation create(GeoLocation geolocation);

    List<GeoLocation> findAll();
}
