package com.manjesh.microservices.controller;

import com.manjesh.microservices.model.GeoLocation;
import com.manjesh.microservices.services.GeoLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 3/7/2017.
 */

@RestController
@RequestMapping("geolocation")
public class GeoLocationController {

    @Autowired
    private GeoLocationService geoLocationService;

    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public GeoLocation create(@RequestBody GeoLocation geoLocation) {
        return geoLocationService.create(geoLocation);
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<GeoLocation> findAll() {
        return geoLocationService.findAll();
    }
}
