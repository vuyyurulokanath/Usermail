package com.prp.mail;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
@SpringBootApplication
@EnableScheduling
public class Application {
	 private static Logger log = LoggerFactory.getLogger(Application.class);

	    @Autowired
	    private EmailService emailService;

	    public static void main(String[] args) throws Exception {
	        SpringApplication.run(Application.class, args);
	    }
	    @Scheduled(fixedRate=1000)
	public void run() throws Exception {
		 log.info("Spring Mail - Sending Simple Email with JavaMailSender Example");

	        Mail mail = new Mail();
	        mail.setFrom("noreplay@gmail.com");
	        mail.setTo("lokanath.vuyyuru@xcubelabs.com");
	        mail.setSubject("noreplay@gmail.com");
	        mail.setContent("OTP :"+Math.round(Math.random()*10000));

	        emailService.sendSimpleMessage(mail);
	    }

}
//private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
//
//String date="14:45:22";
//
//
//
//@Scheduled(fixedRate = 1000)
//public void reportCurrentTime() {
//    
//    if(dateFormat.format(new Date()).equals(date))
//    {
//    	logger.info("The time is now {}", dateFormat.format(new Date()));
//    	System.out.println("wake up time");
//
//    	
//    }
//    else
//    {
//    	logger.info("time is running to make alert");
//    }
//  
//}