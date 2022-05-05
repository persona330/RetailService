package com.example.retail.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class MainController
{
    @RequestMapping("/")
    public String home() { return "Привет"; }

    @RequestMapping("/admin")
    public String admin() { return "Страница администратора"; }

    @RequestMapping("/header")
    public String header() { return "Заголовок"; }
}
