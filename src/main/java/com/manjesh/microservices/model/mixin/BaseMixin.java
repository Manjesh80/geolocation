package com.manjesh.microservices.model.mixin;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Map;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 3/22/2017.
 */
public abstract class BaseMixin implements Serializable {

    @JsonAnySetter
    public abstract void addDynamicProperties(String propertyName, String propertyValue);

    @JsonAnyGetter
    public abstract Map<String, Object> getDynamicProperties();

    @JsonIgnore
    public abstract boolean isDynamicPropertiesPresent();
}
