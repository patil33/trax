package com.trackz.services;

import java.util.List;

import com.trackz.entities.Contact;

public interface ContactService {
public void saveContact(Contact contact);
public List<Contact> getAllContacts();
public Contact findContactById(long id);
}
