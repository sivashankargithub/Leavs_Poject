package com.sangamone.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sangamone.controller.LeaveApplyController;
import com.sangamone.entity.LeaveApplyEntity;
import com.sangamone.entity.LeaveUserEntity;
import com.sangamone.repository.LeaveApplyRepo;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

@Service
public class EmailService {
	@Autowired
	SendGrid sendGrid;
	
	public Response sendMail(LeaveApplyEntity leaveApplyEntity) {
		LeaveUserEntity leaveUserEntity2 = new LeaveUserEntity();
		String to = leaveUserEntity2.getUser_email();
		String subject = "Leave Application Submitted.";
		String body = "Your leave application has been submitted successfully.";
		Mail mail = new Mail(new Email("suhasacharyag.sangamone@gmail.com"),subject,new Email("sivashankarchandrappa@gmail.com"),new Content("text/plain",body));
		mail.setReplyTo(new Email("sivashankarchandrappa@gmail.com"));
		Request request=new Request();
		
		Response response=null;
		
		try {
			request.setMethod(Method.POST);
			request.setEndpoint("mail/send");
			request.setBody(mail.build());
			response = this.sendGrid.api(request);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
		return response;
	}
}
