package com.ibm.springboot.demo.aspect;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DepartmentServiceAspect {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Before("execution(* com.ibm.springboot.demo.service.*.*(..))")
	public void serviceMethodBefore() {
		System.out.println("It is working");
		LOG.info("A method from EmployeeServiceImpl was invoking.");
	}
	
	@After("execution(* com.ibm.springboot.demo.service.*.*(..))")
	public void serviceMethodAfter() {
		LOG.info("A method from EmployeeServiceImpl was invoked.");
	}
	
	@AfterReturning("execution(* com.ibm.springboot.demo.service.*.*(..))")
	public void serviceSuccess() {
		LOG.info("Data returned successfully.");
		
		final String to = "fiqbal997@gmail.com";
	      final String from = "fiqbal997@gmail.com";

	      String host = "smtp.gmail.com";
	      Properties properties = System.getProperties();

	      properties.put("mail.smtp.host", host);
	      properties.put("mail.smtp.port", "587");
	      properties.put("mail.smtp.starttls.enable", "true");
	      properties.put("mail.smtp.auth", "true");

	      Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
	          protected PasswordAuthentication getPasswordAuthentication() {
	              return new PasswordAuthentication("fiqbal997@gmail.com", "yjss ntks mhvq immf");
	          }
	      });

	      session.setDebug(true);
	      try {
	          MimeMessage message = new MimeMessage(session);

	          message.setFrom(new InternetAddress(from));
	          message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	          message.setSubject("This is the Subject Line!");
	          message.setText("This is actual message");

	          System.out.println("sending...");
	          Transport.send(message);
	          System.out.println("Sent message successfully....");
	      } catch (MessagingException mex) {
	          mex.printStackTrace();
	      }
	   }
	
	
	@AfterThrowing("execution(* com.ibm.springboot.demo.service.*.*(..))")
	public void serviceFailed() {
		LOG.info("Data could not be returned");
	}
	
	
}
