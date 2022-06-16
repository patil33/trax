package com.trackz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trackz.entities.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long> {

}
