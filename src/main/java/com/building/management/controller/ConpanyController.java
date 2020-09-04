package com.building.management.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class ConpanyController {

    @GetMapping("")
    public ResponseEntity<?> getListCompany(){
        return null;
    }
}
