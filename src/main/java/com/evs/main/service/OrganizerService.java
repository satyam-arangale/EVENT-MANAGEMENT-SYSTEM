package com.evs.main.service;

import java.util.Optional;

import com.evs.main.entities.Organizer;

public interface OrganizerService {

	Organizer createOrganizer(Organizer organizer);

	Optional<Organizer> getOrganizerById(Long id);

	Organizer updateOrganizer(Long id, Organizer updatedOrganizer);

	void deleteOrganizer(Long id);
}
