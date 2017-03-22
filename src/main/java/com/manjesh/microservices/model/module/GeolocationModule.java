package com.manjesh.microservices.model.module;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.manjesh.microservices.model.GeoLocation;
import com.manjesh.microservices.model.mixin.GeoLocationMixin;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 3/22/2017.
 */
public class GeolocationModule extends SimpleModule {

    @Override
    public void setupModule(SetupContext context) {
        context.setMixInAnnotations(GeoLocation.class, GeoLocationMixin.class);
    }
}
