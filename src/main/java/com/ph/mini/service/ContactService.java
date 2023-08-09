package com.ph.mini.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ph.mini.binding.ContactForm;

public interface ContactService {

	public String saveContact(ContactForm form);
	
	public List<ContactForm> viewContact();
	
	public ContactForm editContact(Integer contactId);
	
	public List<ContactForm> deleteContact(Integer contactId);
	
}
