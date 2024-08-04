package com.evs.main.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evs.main.customexceptions.EventNotFoundException;
import com.evs.main.entities.Event;
import com.evs.main.repositories.EventRepository;
import com.evs.main.service.EventService;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventRepository eventRepository;

	@Override
	public Event createEvent(Event event) {
		return eventRepository.save(event);
	}

	@Override
	public List<Event> getAllEvents() {
		return eventRepository.findAll();
	}

	@Override
	public Optional<Event> getEventById(Long id) {
		return eventRepository.findById(id);
	}

	@Override
	public Event updateEvent(Long id, Event updatedEvent) {
		return eventRepository.findById(id).map(event -> {
			event.setEventName(updatedEvent.getEventName());
			event.setEventDate(updatedEvent.getEventDate());
			event.setDescription(updatedEvent.getDescription());
			event.setOrganizer(updatedEvent.getOrganizer());
			event.setVenue(updatedEvent.getVenue());
			return eventRepository.save(event);
		}).orElseThrow(() -> new RuntimeException("Event not found"));
	}

	@Override
	public void deleteEvent(Long id) {
		eventRepository.findById(id).ifPresent(eventRepository::delete);
	}

	@Override
	public List<Event> getEventByVenue(Long venueId) {
		return eventRepository.findByVenueId(venueId);
	}

	@Override
	public List<Event> getEventsByOrganizer(Long organizerId) {
		return eventRepository.findByOrganizerId(organizerId);
	}

}
