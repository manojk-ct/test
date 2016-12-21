/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zcon.mobileris.services.impl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 *
 * @author PradnyaS
 */
@Service("mailService")
public class MailService {
    
    //@Autowired
    //Users user;
    
    //@Autowired
    //ContactUs contactus;
    
    @Autowired
    private JavaMailSender mailSender; //Send the given simple mail message
    
    @Autowired
    private SimpleMailMessage simpleMailMessage ;//   from ,to,subject ,text
           
    @Autowired
    private MimeMessage mimeMessage;  
    
    public void sendMail(String to,String Subject,String body){
        
        MimeMessage  mimeMessage =mailSender.createMimeMessage();
     
        try{

        MimeMessageHelper helper =new MimeMessageHelper(mimeMessage,true);
        helper.setFrom(simpleMailMessage.getFrom());
        simpleMailMessage.setTo("pradnya.sutkar@zconsolutions.com");

        
        helper.setTo(to);
        helper.setSubject(Subject);

        helper.setText(body, true);
        mailSender.send(mimeMessage);
        }
    catch(MessagingException e){
       e.printStackTrace(); 
    }
    }
}
