package com.ibm.learning.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.learning.emailer.iEmailerService;


@RestController
public class EmailServiceController {
	
	//iEmailerService emailService = new  DummyEmailSender();
	//Dont creaet any obj with specific type let spring create it 
	//@Autowired      //at instance variable
	iEmailerService emailService;
	
	
	public iEmailerService getEmailService() {
		return emailService;
	}

	/*@Autowired		//at setter method
	public void setEmailService(iEmailerService dummyEmailSender) {
		this.emailService = dummyEmailSender;
	}*/
		@Autowired //using constructor
		public EmailServiceController( iEmailerService abc) {
		this.emailService = abc;
		}
	// http://localhost:8080/sendemail
	@RequestMapping("/sendemail")
	public String email() throws MessagingException{
		//call sendEMail method
		emailService.sendEmail("stevejobs@apple.com", "Launching of new Apple Model", "Body of the email");
		
		
		return "Email Sent";
	}
	

	
}