package com.cruiseline.venue.service;

import com.cruiseline.venue.model.Venue;
import com.cruiseline.venue.repository.VenueRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenueService {
    private VenueRepository venueRepository;

    public VenueService(VenueRepository repo) {
        this.venueRepository = repo;
    }

    public Iterable<Venue> list() {
        return venueRepository.findAll();
    }

    public Iterable<Venue> save(List<Venue> venues) {
        return venueRepository.saveAll(venues);
    }
}
