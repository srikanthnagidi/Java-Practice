package com.springboot.graphql.service;

import com.springboot.graphql.entity.Location;
import com.springboot.graphql.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    LocationRepository locationRepository;

    @Override
    public List<Location> retrieveLocations() {
        return  (List<Location>) locationRepository.findAll();
    }
}
