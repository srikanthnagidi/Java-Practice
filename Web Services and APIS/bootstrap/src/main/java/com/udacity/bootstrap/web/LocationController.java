package com.udacity.bootstrap.web;

import com.udacity.bootstrap.entity.Location;
import com.udacity.bootstrap.service.LocationService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ApiResponses(value = {
        @ApiResponse(code=400, message = "This is bad request, please follow the API documentation for proper request"),
        @ApiResponse(code=401, message = "Due to security constraint, your access request cannot be authorized"),
        @ApiResponse(code = 500, message = "Server is down, please make sure that Location microservice is running")
})
public class LocationController {
    private LocationService locationService;

    @Autowired
    public void setLocationService(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/locations")
    public ResponseEntity<List<Location>> getAllLocations() {
        List<Location> list = locationService.retrieveLocations();
        return new ResponseEntity<List<Location>>(list, HttpStatus.OK);
    }

}
