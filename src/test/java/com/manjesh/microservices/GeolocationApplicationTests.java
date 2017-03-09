package com.manjesh.microservices;

import com.manjesh.microservices.model.GeoLocation;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = {GeolocationApplication.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@ContextConfiguration
public class GeolocationApplicationTests {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void contextLoads() {

    }

    @Test
    public void testAddGeolocation() {
        GeoLocation geoLocation = new GeoLocation(11, 12, UUID.randomUUID(), System.currentTimeMillis());
        ResponseEntity<GeoLocation> forEntity =
                restTemplate.postForEntity("/geolocation", geoLocation, GeoLocation.class);
        Assert.assertEquals("Geolocation creation test", 200, forEntity.getStatusCode().value());
    }

    @Test
    public void testGetAllGeolocation() {
        ResponseEntity<GeoLocation[]> forEntity = restTemplate.getForEntity("/geolocation", GeoLocation[].class);
        Assert.assertEquals("Geolocation creation test", 200, forEntity.getStatusCode().value());
        Assert.assertEquals("Geolocation creation test", 1, forEntity.getBody().length);
    }
}
