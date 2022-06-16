package com.trackz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trackz.entities.Billing;
import com.trackz.entities.Contact;
import com.trackz.services.BillingService;
import com.trackz.services.ContactService;

@Controller
public class BillingController {

	@Autowired
 private ContactService contactService;
	@Autowired
	private BillingService billingService;
	
	@RequestMapping("/createBill")
	public String createBill(@RequestParam("bid") long id,ModelMap model) {

		Contact contact = contactService.findContactById(id);
		model.addAttribute("contact", contact);
		return "create_bill";
		
	}
	@RequestMapping("/saveBill")
	public String saveBill(@ModelAttribute("bill") Billing bill,ModelMap model) {
		billingService.saveBill(bill);
		List<Billing> billing = billingService.getAllBilling();
		model.addAttribute("billing", billing);
		
		
		return "billing_search_result";
	}

}