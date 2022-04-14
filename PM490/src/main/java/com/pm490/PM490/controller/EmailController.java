package com.pm490.PM490.controller;

import com.pm490.PM490.dto.EmailDto;
import com.pm490.PM490.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmailController {
    @Autowired
    private EmailService emailHelper;

    @PostMapping(value = "/sendemail")
    public String sendEmail(@RequestBody EmailDto email)
    {

        emailHelper.sendEmail(email);
        return "Email sent successfully";
    }

}


