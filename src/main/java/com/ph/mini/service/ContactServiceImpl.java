package com.ph.mini.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ph.mini.binding.ContactForm;
import com.ph.mini.entities.Contact;
import com.ph.mini.repository.ContactRepository;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepo;
	
	
	@Override
	public String saveContact(ContactForm form) {
		
		Contact entity = new Contact();
		BeanUtils.copyProperties(form, entity);
		
		entity = contactRepo.save(entity);
		if(entity != null)
		{
			return "Saved Sucessfully";
		}
		return "Failed to Save";
		
	}

	@Override
	public List<ContactForm> viewContact() {
		List<ContactForm> dataList = new ArrayList<>();
		
		List<Contact> findAll = contactRepo.findAll();
		for(Contact entity : findAll)
		{
			ContactForm form=new ContactForm();
			BeanUtils.copyProperties(entity, form);
			dataList.add(form);
		}
		return dataList;
	}

	@Override
	public ContactForm editContact(Integer contactId) {
		Optional<Contact> findById = contactRepo.findById(contactId);
		if(findById.isPresent()) {
			Contact entity=findById.get();
			ContactForm form = new ContactForm();
			BeanUtils.copyProperties(entity, form);
			return form;
		}
		return null;
	}

	@Override
	public List<ContactForm> deleteContact(Integer contactId) {
		contactRepo.deleteById(contactId);
		
		List<ContactForm> dataList = new ArrayList<>();
		List<Contact> findAll = contactRepo.findAll();
		for(Contact entity : findAll)
		{
			ContactForm form=new ContactForm();
			BeanUtils.copyProperties(entity, form);
			dataList.add(form);
		}
		return dataList;
	}

}
