package com.mimie.cetimBackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EquipmentController {

    @GetMapping("/")
    public String home(){
        return "welcome to CETIM EQUIPMENT MANAGEMENT SYSTEM";
    }
}
