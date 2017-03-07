package com.manjesh.microservices.services;

import com.manjesh.microservices.model.GeoLocation;
import com.manjesh.microservices.repository.GeoLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 3/7/2017.
 */
@Service
public class GeoLocationServiceImpl implements GeoLocationService {

    @Autowired
    private GeoLocationRepository repository;

    @Override
    public GeoLocation create(GeoLocation geolocation) {
        repository.addGeoLocation(geolocation);
        return geolocation;
    }

    @Override
    public List<GeoLocation> findAll() {
        return repository.getGeoLocations();
    }
}
