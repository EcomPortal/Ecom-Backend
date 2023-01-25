package com.ecom.app.serviceImpl;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.ecom.app.service.EmailServiceVM;

@Service
public class EmailServiceVMImpl implements EmailServiceVM {

	@Autowired
	private JavaMailSender javaMailService;

	

//	@Value("${user.web.path}")
//	private String webPath;

	

	@Override
	public void sendNewWelcomeLetter(String subject, String email, String defaultPass, String name) {
		try {
			MimeMessage mailMessage = javaMailService.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mailMessage, true);
//            
			helper.setTo(email);
			helper.setSubject(subject);
			helper.setText("Here Is Your LoginDetails.." + " \n\nUsername:[" + email + "] \n\nPassword:[" + defaultPass
					+ "] \n\nThanks");
			javaMailService.send(mailMessage);
//           
			// send(mailMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}