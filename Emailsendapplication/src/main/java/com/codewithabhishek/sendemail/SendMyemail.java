package com.codewithabhishek.sendemail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class SendMyemail {



    @Autowired
    private JavaMailSender javaMailSenderl;

    public void  sendmymail(String subject , String msg ,String too){
        SimpleMailMessage sm = new SimpleMailMessage();
        sm.setTo(too);
        sm.setFrom("abhissingh98@outlook.com");
        sm.setSubject(subject);
        sm.setText(msg);
        javaMailSenderl.send(sm);


    }
}
