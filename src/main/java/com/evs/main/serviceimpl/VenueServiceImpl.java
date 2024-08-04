package com.evs.main.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evs.main.entities.Venue;
import com.evs.main.repositories.VenueRepository;
import com.evs.main.service.VenueService;

@Service
public class VenueServiceImpl implements VenueService {
	@Autowired
	private VenueRepository venueRepository;

	@Override
	public Venue createVenue(Venue venue) {
		return venueRepository.save(venue);
	}

	@Override
	public Optional<Venue> getVenueById(Long id) {
		return venueRepository.findById(id);
	}

	@Override
	public Venue updateVenue(Long id, Venue updatedVenue) {
		return venueRepository.findById(id).map(venue -> {
			venue.setName(updatedVenue.getName());
			venue.setLocation(updatedVenue.getLocation());
			venue.setCapacity(updatedVenue.getCapacity());
			return venueRepository.save(venue);
		}).orElseThrow(() -> new RuntimeException("Venue not found"));
	}

	@Override
	public void deleteVenue(Long id) {
		venueRepository.findById(id).ifPresent(venueRepository::delete);
	}
}
