package com.evs.main.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evs.main.entities.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

	List<Event> findByVenueId(Long venueId);

	List<Event> findByOrganizerId(Long organizerId);

}
