package com.sonda.demo.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "user")
public class UserResources {
    @GetMapping
    public String getUser() {
        return "teste url";
    }
}
