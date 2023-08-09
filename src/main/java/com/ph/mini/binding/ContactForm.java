package com.ph.mini.binding;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ContactForm {

	private Integer contactId;
	private String contactName;
	private String contactEmail;
	private long contactNumber;
	private String ActiveSw;
	private LocalDate createDate;
	private LocalDate updateDate;
	
	
}
