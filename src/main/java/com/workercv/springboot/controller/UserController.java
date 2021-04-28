package com.workercv.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class UserController {

    @GetMapping("/{id}")
    public String loginForm(@PathVariable("id") String id) {
        System.out.println(UUID.randomUUID().toString().replace("-", "").toLowerCase());
        return id;
    }

}
