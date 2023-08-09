package com.ph.mini.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ph.mini.entities.Contact;
@Repository
public interface ContactRepository extends JpaRepository<Contact, Serializable> {

}
