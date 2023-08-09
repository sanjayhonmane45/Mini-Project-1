package com.ph.mini.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ph.mini.binding.ContactForm;
import com.ph.mini.repository.ContactRepository;
import com.ph.mini.service.ContactService;
import com.ph.mini.service.ContactServiceImpl;

@RestController
@RequestMapping("/home")
public class ContactRestController {

	@Autowired
	private ContactServiceImpl service;
	
	@Autowired
	private ContactRepository repo;
	
	
	@PostMapping("/save")
	public String saveContact(@RequestBody ContactForm form)
	{
		String status = service.saveContact(form);
		return status;
	}
	
	@GetMapping("/contacts")
	public List<ContactForm> viewAllContacts(){
		return service.viewContact();
	}
	
	@GetMapping("/edit/{contactId}")
	public ContactForm editContact(@PathVariable Integer contactId) {
		return service.editContact(contactId);
	}
	
	@GetMapping("/delete/{contactId}")
	public List<ContactForm> deleteContact(@PathVariable Integer contactId) {
		return service.deleteContact(contactId);
	}
}
