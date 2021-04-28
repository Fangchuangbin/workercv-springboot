package com.workercv.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/{id}")
    public int loginForm(@PathVariable("id") Integer id) {
        System.out.println(id);
        return id;
    }

}
