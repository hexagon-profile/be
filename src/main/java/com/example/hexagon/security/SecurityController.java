package com.example.hexagon.security;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@Hidden
@RestController
public class SecurityController {

    @GetMapping("/")
    public String index() {
        return "home";
    }

    @GetMapping("/user")
    public String user() {
        return "user";
    }
    @GetMapping("/admin/pay")
    public String adminPay() {
        return "admin Pay";
    }
    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }
}
