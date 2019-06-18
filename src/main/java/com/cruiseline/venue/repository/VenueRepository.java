package com.cruiseline.venue.repository;

import com.cruiseline.venue.model.Venue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VenueRepository extends CrudRepository<Venue, Long> {
    public List<Venue> findByReservationId(Long reservationId);
}
