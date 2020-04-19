package com.services;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mail.MyConstants;

@CrossOrigin
@Controller
public class EmailService {

	@Autowired
	private JavaMailSender emailSender;

	@ResponseBody
	@RequestMapping("/sendHtmlEmail")
	public String sendHtmlEmail() throws MessagingException {

		MimeMessage message = emailSender.createMimeMessage();

		boolean multipart = true;

		MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");

		String htmlMsg = "<h3>Im testing send a HTML email</h3>"
				+ "<img src='http://www.apache.org/images/asf_logo_wide.gif'>";

		message.setContent(htmlMsg, "text/html");

		helper.setTo(MyConstants.FRIEND_EMAIL);

		helper.setSubject("Test send HTML email");

		this.emailSender.send(message);

		return "Email Sent!";
	}

}
