package com.soterianetworks.spase.sample.hello.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyProfileRestController {

    @GetMapping("/my-profile")
    @ResponseStatus(HttpStatus.OK)
    public Object getMyProfile() {
        return SecurityContextHolder.getContext().getAuthentication().getDetails();
    }

}
