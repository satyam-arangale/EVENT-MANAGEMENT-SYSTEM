package com.evs.main.service;

import java.util.Optional;

import com.evs.main.entities.Venue;

public interface VenueService {

	Venue createVenue(Venue venue);

	Optional<Venue> getVenueById(Long id);

	Venue updateVenue(Long id, Venue updatedVenue);

	void deleteVenue(Long id);

}
