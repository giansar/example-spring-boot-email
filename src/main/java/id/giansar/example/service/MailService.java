package id.giansar.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import id.giansar.example.model.MailFormModel;

@Service
public class MailService {

	@Autowired
	private MailSender mailSender;

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private SimpleMailMessage simpleMailTemplate;

	public void sendSimpleMail(MailFormModel model) {
		SimpleMailMessage smm = new SimpleMailMessage(simpleMailTemplate);
		smm.setTo(model.getTo());
		smm.setSubject(model.getSubject());
		smm.setText(model.getBody());
		try {
			mailSender.send(smm);
		} catch (MailException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void sendMimeMail(MailFormModel model) {
		//to do
	}
}
