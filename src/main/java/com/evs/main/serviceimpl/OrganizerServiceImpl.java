package com.evs.main.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evs.main.entities.Organizer;
import com.evs.main.repositories.OrganizerRepository;
import com.evs.main.service.OrganizerService;

@Service
public class OrganizerServiceImpl implements OrganizerService {

	@Autowired
	private OrganizerRepository organizerRepository;

	@Override
	public Organizer createOrganizer(Organizer organizer) {
		return organizerRepository.save(organizer);
	}

	@Override
	public Optional<Organizer> getOrganizerById(Long id) {
		return organizerRepository.findById(id);
	}

	@Override
	public Organizer updateOrganizer(Long id, Organizer updatedOrganizer) {
		return organizerRepository.findById(id).map(organizer -> {
			organizer.setName(updatedOrganizer.getName());
			organizer.setContactInfo(updatedOrganizer.getContactInfo());
			return organizerRepository.save(organizer);
		}).orElseThrow(() -> new RuntimeException("Organizer not found"));
	}

	@Override
	public void deleteOrganizer(Long id) {
		organizerRepository.findById(id).ifPresent(organizerRepository::delete);
	}

}
