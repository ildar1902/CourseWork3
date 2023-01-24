package me.ildar.coursework3.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class FirstController {
    @GetMapping
    public String hello() {
        return "Приложение запущено.......";
    }
}
