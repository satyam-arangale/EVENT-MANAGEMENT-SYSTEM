package com.evs.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evs.main.customexceptions.EventNotFoundException;
import com.evs.main.entities.Event;

import com.evs.main.service.EventService;

@RestController
@RequestMapping("/events")
public class EventController {

	@Autowired
	private EventService eventService;

	@PostMapping
	public Event createEvent(@RequestBody Event event) {
		return eventService.createEvent(event);
	}

	@GetMapping
	public List<Event> getAllEvents() {
		return eventService.getAllEvents();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Event> getEventById(@PathVariable Long id) {
		return eventService.getEventById(id)
				           .map(ResponseEntity::ok)
				           .orElseThrow(() -> new EventNotFoundException("Event not found with id " + id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody Event updatedEvent) {
		try {
			return ResponseEntity.ok(eventService.updateEvent(id, updatedEvent));
		} catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
		eventService.deleteEvent(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/venue/{venueId}")
	public List<Event> getEventByVenue(@PathVariable Long venueId) {
	
		System.out.println("Venue id entered by client "+ venueId);
		return eventService.getEventByVenue(venueId); 
	}

	@GetMapping("/organizer/{organizerId}")
	public List<Event> getEventsByOrganizer(@PathVariable Long organizerId) {
		return eventService.getEventsByOrganizer(organizerId);
	}
}
