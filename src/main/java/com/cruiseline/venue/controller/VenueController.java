package com.cruiseline.venue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cruiseline.venue.model.Venue;
import com.cruiseline.venue.service.VenueService;

import io.micrometer.core.instrument.MeterRegistry;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/")
@Api(value = "/", tags = "Venues", description = "Operations about venues")
public class VenueController {
    @Autowired
    private VenueService venueService;
    
    @Autowired
    MeterRegistry registry;


    @ApiOperation(
            value = "Find all venue records for a given page and size",
            notes = "Expensive operation as it retrieves all the records", response = Venue.class)
    @ApiResponses(value = {@ApiResponse(code = 404, message = "Venues Not Found")})
    @GetMapping(value = "/findAll")
    public Iterable<Venue> findAll() {
    	
    	// counter to count different types of messages received
        registry.counter("custom.metrics.numofcalls").increment();
        return venueService.list();
    }

}
