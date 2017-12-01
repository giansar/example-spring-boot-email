package id.giansar.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import id.giansar.example.model.MailFormModel;
import id.giansar.example.service.MailService;

@RestController("/mail")
public class MailController {
	
	@Autowired
	private MailService mailService;
	
	@PostMapping
	public String sendMail(@RequestBody MailFormModel model) {
		mailService.sendSimpleMail(model);
		return "sent";
	}
}
