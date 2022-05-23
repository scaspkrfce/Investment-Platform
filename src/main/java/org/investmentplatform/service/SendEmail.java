package org.investmentplatform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendEmail
{
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendEmail(String to, String subject, String content)
	{
		SimpleMailMessage email = new SimpleMailMessage();
		email.setFrom("fusanest2022@gmail.com");
        email.setTo(to);
        email.setSubject(subject);
        email.setText(content);
        mailSender.send(email);
        System.out.println("Security mail sent to: "+to);
	}
	public SendEmail()
	{
		
	}
}
