package com.trackz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trackz.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
