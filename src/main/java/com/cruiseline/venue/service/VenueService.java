package com.cruiseline.venue.service;

import com.cruiseline.venue.model.Venue;
import com.cruiseline.venue.repository.VenueRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class VenueService {

    Log log = LogFactory.getLog(VenueService.class);

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

    public ResponseEntity<Void> updateByReservationId(long reservationId, String personName) {
        log.info("Came inside updateByReservationId with reservationId : " + reservationId);
        List<Venue> venues = venueRepository.findByReservationId(reservationId);

        if (!CollectionUtils.isEmpty(venues)) {
            venues.parallelStream().forEach(venue -> {
                venue.setPersonName(personName);
                log.debug("Updated " + venue.toString());
                venueRepository.save(venue);
            });
            log.info("updateByReservationId updated count: " + venues.size());
            new ResponseEntity<Void>(HttpStatus.OK);
        }
        else
            log.info("updateByReservationId return count: 0");
        return new ResponseEntity<Void>(HttpStatus.NOT_MODIFIED);
    }
}
