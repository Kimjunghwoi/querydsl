package study.querydsl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController2 {

    @GetMapping("/hello/querydsl")
    public String hello() {
        return "hello";
    }
}
