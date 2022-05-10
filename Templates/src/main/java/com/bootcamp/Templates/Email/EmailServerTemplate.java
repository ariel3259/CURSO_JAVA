package com.bootcamp.Templates.Email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.bootcamp.Templates.Model.Users;

@Service
public class EmailServerTemplate{

	private final JavaMailSender mailSender;
	
	private final TemplateEngine template;
	
	public EmailServerTemplate(JavaMailSender sender, TemplateEngine engine) {
		mailSender = sender;
		template = engine;
	}
	

	public boolean sendEmail(Users user) {
		boolean send;
		Context context = new Context();
		context.setVariable("user", user);
		String c = template.process("emails/index", context);
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		try {
			helper.setSubject( "Welcome " + user.getName());
			helper.setText(c, true);
			helper.setTo(user.getEmail());
			mailSender.send(message);
			send = true;
		}catch(MessagingException e) {
			send = false;
		}
		return send;
	}
	
}
