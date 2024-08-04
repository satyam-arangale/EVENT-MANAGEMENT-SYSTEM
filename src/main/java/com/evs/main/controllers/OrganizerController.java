package com.evs.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evs.main.entities.Organizer;
import com.evs.main.service.OrganizerService;

@RestController
@RequestMapping("/api/organizers")
public class OrganizerController {

	@Autowired
	private OrganizerService organizerService;

	@PostMapping
	public Organizer createOrganizer(@RequestBody Organizer organizer) {
		return organizerService.createOrganizer(organizer);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Organizer> getOrganizerById(@PathVariable Long id) {
		return organizerService.getOrganizerById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PutMapping("/{id}")
	public ResponseEntity<Organizer> updateOrganizer(@PathVariable Long id, @RequestBody Organizer updatedOrganizer) {
		try {
			return ResponseEntity.ok(organizerService.updateOrganizer(id, updatedOrganizer));
		} catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteOrganizer(@PathVariable Long id) {
		organizerService.deleteOrganizer(id);
		return ResponseEntity.ok().build();
	}
}
