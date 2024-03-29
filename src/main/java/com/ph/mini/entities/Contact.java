package com.ph.mini.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import lombok.Data;

@Entity
@Table(name="CONTACT_DTLS")
@Data
public class Contact {

	@Id
	@GeneratedValue
	@Column(name="CONTACT_ID")
	Integer contactId;
	
	@Column(name="CONTACT_NAME")
	private String contactName;
	
	@Column(name="CONTACT_EMAIL")
	private String contactEmail;
	
	@Column(name="CONTACT_NUMBER")
	private long contactNumber;
	
	@Column(name="ACTIVE_SW")
	private String ActiveSw;
	
	@Column(name="CREATE_DATE")
	@CreationTimestamp
	private LocalDate createDate;
	
	@Column(name="UPDATE_DATE")
	@UpdateTimestamp
	private LocalDate updateDate;
	
	
	
	
}
