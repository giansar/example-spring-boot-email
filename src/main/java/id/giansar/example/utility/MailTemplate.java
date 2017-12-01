package id.giansar.example.utility;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class MailTemplate {
	
	@Value("${custom.properties.mail.from}")
	private String from;
	
	@Bean
	public SimpleMailMessage simpleMailTemplate() {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom(from);
		return simpleMailMessage;
	}
}
