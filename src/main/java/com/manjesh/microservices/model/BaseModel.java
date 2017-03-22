package com.manjesh.microservices.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 3/22/2017.
 */
public class BaseModel implements Serializable {

    private Map<String, Object> dynamicProperties = new LinkedHashMap<>();

    @JsonAnySetter
    public void addDynamicProperties(String propertyName, Object propertyValue) {
        dynamicProperties.put(propertyName, propertyValue);
    }

    @JsonIgnore
    public boolean isDynamicPropertiesPresent() {
        return dynamicProperties.size() == 0;
    }
}
