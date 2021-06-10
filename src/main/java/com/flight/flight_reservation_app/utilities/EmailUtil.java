package com.flight.flight_reservation_app.utilities;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {
	
	@Autowired
	private JavaMailSender sender;
	
	public void sendItinerary(String toAddress, String filePath,String departureCity,String arrivalCity,String firstName) {
		System.out.println(filePath);
			
		MimeMessage message = sender.createMimeMessage();
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message,true);
			messageHelper.setTo(toAddress);
			messageHelper.setSubject("Your Flight ticket for "+departureCity+" to "+arrivalCity+"");
			messageHelper.setText("Please find the attached ticket ");
			messageHelper.addAttachment("Flight Ticket Pname:"+firstName+"", new File(filePath) );
			sender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
