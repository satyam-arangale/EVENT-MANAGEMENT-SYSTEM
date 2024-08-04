package com.evs.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evs.main.entities.Organizer;

@Repository
public interface OrganizerRepository extends JpaRepository<Organizer, Long>{

	
}
