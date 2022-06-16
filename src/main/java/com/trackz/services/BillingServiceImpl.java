package com.trackz.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trackz.entities.Billing;
import com.trackz.repositories.BillingRepository;

@Service
public class BillingServiceImpl implements BillingService {
@Autowired
private BillingRepository billingRepo;

	@Override
	public void saveBill(Billing bill) {
		billingRepo.save(bill);

	}

	@Override
	public List<Billing> getAllBilling() {
		List<Billing> billing = billingRepo.findAll();
		return billing;
	}
}