package com.trackz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.trackz.entities.Contact;
import com.trackz.entities.Lead;
import com.trackz.services.ContactService;
import com.trackz.services.LeadService;

@Controller
public class ContactController {

	@Autowired
	private LeadService leadService;
	@Autowired

	private ContactService contactService;

	@RequestMapping("/convertEmail")
	public String convertEmail(@RequestParam("id") long id, ModelMap model) {
		try {
			Lead lead = leadService.findLeadById(id);
			Contact contact = new Contact();
			contact.setFirstName(lead.getFirstName());
			contact.setLastName(lead.getLastName());
			contact.setLeadSource(lead.getLeadSource());
			contact.setEmail(lead.getEmail());
			contact.setMobile(lead.getMobile());

			contactService.saveContact(contact);

			leadService.deleteLeadById(id);

			List<Contact> contacts = contactService.getAllContacts();
			model.addAttribute("contacts", contacts);

			return "contact_search_result";
		} catch (Exception e) {
			model.addAttribute("msg", "Already this email converted");
		}
		return null;
	}

	@RequestMapping("/contactInfo")
	public String leadinfo(@RequestParam("id") long id, ModelMap model) {
		Contact contact = contactService.findContactById(id);
		model.addAttribute("contact", contact);
		return "contact_info";
	}

	@RequestMapping("/listallcontacts")
	public String listAllContacts(ModelMap model) {

		List<Contact> contacts = contactService.getAllContacts();
		model.addAttribute("contacts", contacts);

		return "contact_search_result";

	}

}
