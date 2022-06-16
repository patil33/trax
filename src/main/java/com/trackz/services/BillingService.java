package com.trackz.services;

import java.util.List;

import com.trackz.entities.Billing;

public interface BillingService {

	public void saveBill(Billing bill);

	public List<Billing> getAllBilling();

}
