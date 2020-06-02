package com.codewithabhishek.controller;


import com.codewithabhishek.Bean.SendBean;
import com.codewithabhishek.sendemail.SendMyemail;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SendEmail {

     @Autowired
     private SendMyemail sendMyemail;

    @GetMapping("/")
    public String send(Model model){
        model.addAttribute("email", new SendBean());
        return "index";
    }


    @PostMapping(value = "/send")
    public String Sendemail(@ModelAttribute SendBean ta) throws JsonProcessingException {


        ObjectMapper ob = new ObjectMapper();
        String subject = ob.writeValueAsString(ta.getSubject());
        String message = ob.writeValueAsString(ta.getMsg());
        StringBuilder sb = new StringBuilder(ta.getTo());
        String too = sb.toString();
        sendMyemail.sendmymail(subject, message,too);
        return "done";

    }

}
