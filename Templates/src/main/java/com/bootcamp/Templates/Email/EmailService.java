package com.bootcamp.Templates.Email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements IEmail {

	@Autowired
	private JavaMailSender mailSender;
	
	
	@Override
	public boolean sendEmail(Email email) {
		return validatedEmail(email.getEmail(), email.getContent(), email.getSubject());
	}
	
	public boolean validatedEmail(String email, String content, String subject){
		boolean send = false;
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		try {
			helper.setTo(email);
			helper.setText(content);
			helper.setSubject(subject);
			mailSender.send(message);
			send = true;
		}catch(MessagingException e) {
			send = false;
		}
		return send;
	}

}
