package com.manjesh.microservices.model.mixin;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.UUID;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 3/7/2017.
 */
public abstract class GeoLocationMixin extends BaseMixin {

    @JsonGetter("user-name")
    public abstract UUID getUserId();

    @JsonSetter("user-name")
    public abstract void setUserId(UUID userId);

    @JsonSetter("user-id")
    public abstract void alternateSetUserId(UUID userId);

}
