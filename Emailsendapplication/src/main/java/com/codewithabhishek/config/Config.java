package com.codewithabhishek.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class Config {

    @Bean
    public JavaMailSender sendMymailPlease() {
        JavaMailSenderImpl jv = new JavaMailSenderImpl();
        jv.setHost("smtp.office365.com");
        jv.setPort(587);
        jv.setUsername("please keep your email");
        jv.setPassword("please keep your password");
        Properties props = jv.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
        return jv;
    }




}
