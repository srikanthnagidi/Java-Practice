package com.springboot.graphql.service;

import com.springboot.graphql.entity.Location;

import java.util.List;

public interface LocationService {
    List<Location> retrieveLocations();
}
