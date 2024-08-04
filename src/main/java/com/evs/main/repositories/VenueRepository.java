package com.evs.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evs.main.entities.Venue;

@Repository
public interface VenueRepository extends JpaRepository<Venue, Long>{

	
}
