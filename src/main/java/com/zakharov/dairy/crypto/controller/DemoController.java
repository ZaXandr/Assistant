package com.zakharov.dairy.crypto.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("demo")
public class DemoController {

    @GetMapping
    public ResponseEntity<String> demo(){
        return ResponseEntity.ok().body("Nice");
    }
}
