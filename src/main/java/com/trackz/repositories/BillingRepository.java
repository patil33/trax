package com.trackz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trackz.entities.Billing;

public interface BillingRepository extends JpaRepository<Billing, Long> {

	

}
