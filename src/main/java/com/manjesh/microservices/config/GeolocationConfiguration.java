package com.manjesh.microservices.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.manjesh.microservices.model.module.GeolocationModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 3/22/2017.
 */

@Configuration
public class GeolocationConfiguration {

    @Bean
    public MappingJackson2HttpMessageConverter getGeolocationMessageConverter() {
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter =
                new MappingJackson2HttpMessageConverter();
        ObjectMapper geolocationObjectMapper = new ObjectMapper();
        geolocationObjectMapper.registerModule(new GeolocationModule());
        geolocationObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mappingJackson2HttpMessageConverter.setObjectMapper(geolocationObjectMapper);
        return mappingJackson2HttpMessageConverter;
    }
}
