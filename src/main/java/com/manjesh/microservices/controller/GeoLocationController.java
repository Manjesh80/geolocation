package com.manjesh.microservices.controller;

import com.manjesh.microservices.MetricSystem;
import com.manjesh.microservices.model.GeoLocation;
import com.manjesh.microservices.services.GeoLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 3/7/2017.
 */

@RestController
@RequestMapping("geolocation")
public class GeoLocationController {

    @Autowired
    private GeoLocationService geoLocationService;

    @Autowired
    private MetricSystem metricSystem;

    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public GeoLocation create(@RequestBody GeoLocation geoLocation) {
        metricSystem.geolocationWriteRequestCount().inc();
        metricSystem.markGeolocationLastWriteTime();
        return geoLocationService.create(geoLocation);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public GeoLocation get(@PathVariable("id") String id) {
        metricSystem.geolocationWriteRequestCount().inc();
        metricSystem.markGeolocationLastWriteTime();
        return new GeoLocation(11, 12, UUID.randomUUID(), System.currentTimeMillis());

    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<GeoLocation> findAll() {
        metricSystem.geolocationWriteRequestCount().inc();
        metricSystem.markGeolocationLastWriteTime();
        return geoLocationService.findAll();
    }
}
