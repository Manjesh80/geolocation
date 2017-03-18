package com.manjesh.microservices;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 3/18/2017.
 */

import javax.annotation.PostConstruct;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Counter;
import com.codahale.metrics.Gauge;
import com.codahale.metrics.Metric;
import com.codahale.metrics.MetricFilter;
import com.codahale.metrics.MetricSet;
import com.codahale.metrics.graphite.Graphite;
import com.codahale.metrics.graphite.GraphiteReporter;
import com.codahale.metrics.jvm.ClassLoadingGaugeSet;
import com.codahale.metrics.jvm.GarbageCollectorMetricSet;
import com.codahale.metrics.jvm.MemoryUsageGaugeSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codahale.metrics.MetricRegistry;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
public class MetricSystem {

    @Autowired
    private MetricRegistry metricRegistry;

    private Counter geolocationWriteRequestCount;
    private Long geolocationLastWriteTime;

    @PostConstruct
    public void init() {
        /*ConsoleReporter consoleReporter = ConsoleReporter.forRegistry(metricRegistry)
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .build();

        consoleReporter.start(10, TimeUnit.SECONDS);*/

        Graphite graphite = new Graphite(new InetSocketAddress("192.168.99.100", 2003));
        GraphiteReporter graphiteReporter = GraphiteReporter.forRegistry(metricRegistry)
                .prefixedWith("com.manjesh.microservices.geolocation")
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .filter(MetricFilter.ALL).build(graphite);

        graphiteReporter.start(10, TimeUnit.SECONDS);


        geolocationWriteRequestCount = metricRegistry.counter("geolocationWriteRequestCount");

        metricRegistry.register("geolocationLastWriteTime", new Gauge<Long>() {
            @Override
            public Long getValue() {
                return geolocationLastWriteTime;
            }
        });

        metricRegistry.registerAll(new MetricSet() {
            @Override
            public Map<String, Metric> getMetrics() {

                Map<String, Metric> metrics = new HashMap<>();
                metrics.put("geolocationMemoryUsage", new MemoryUsageGaugeSet());
                metrics.put("geolocationClassLoading", new ClassLoadingGaugeSet());
                metrics.put("geolocationGarbageCollector", new GarbageCollectorMetricSet());
                return metrics;
            }
        });
    }

    public Counter geolocationWriteRequestCount() {
        return geolocationWriteRequestCount;
    }

    public void markGeolocationLastWriteTime() {
        geolocationLastWriteTime = System.currentTimeMillis();
    }
}