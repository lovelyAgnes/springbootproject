package com.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	@Autowired
    private JavaMailSender mailSender;
	@Value("${mail.fromMail.addr}")
    private String form;
	
	@Value("${spring.mail.username}")
    private String from;

    public void sendEmail2(String to, String subject, String text) {

//        Context context = new Context();
//        context.setVariable("project", "demo");
//        context.setVariable("author", "yimcarson");
//        context.setVariable("code", text);
//        String emailContent = templateEngine.process("mail", context);

//        MimeMessage message = mailSender.createMimeMessage();
//        MimeMessageHelper helper = null;
//        try {
//            helper = new MimeMessageHelper(message, true);
//            helper.setFrom(from);
//            helper.setTo(to);
//            helper.setSubject(subject);
//            helper.setText("test", true);
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//        mailSender.send(message);
    	
    	
    	SimpleMailMessage mailMessage=new SimpleMailMessage();
    	System.out.println(from);
        mailMessage.setFrom(from);
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(text);
        try { mailSender.send(mailMessage);
            System.out.println("发送简单邮件");
        }catch (Exception e){ e.printStackTrace();
            System.out.println("发送简单邮件失败");
        }
    }
    
}

