package com.evs.main.service;

import java.util.List;
import java.util.Optional;

import com.evs.main.entities.Event;

public interface EventService {

	Event createEvent(Event event);

	List<Event> getAllEvents();

	Optional<Event> getEventById(Long id);

	Event updateEvent(Long id, Event updatedEvent);
	
	void deleteEvent( Long id);
	
	List<Event> getEventByVenue( Long venueId);
	
	List<Event> getEventsByOrganizer( Long organizerId);
	
	
}
