package com.example.producer.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/connectionSpeed")
public class speedTestController {

    @PostMapping
    public ResponseEntity<Long> testSpeed(@RequestBody byte[] data){
        log.info("Received connection speed request, size: {} bytes", data.length);
        return ResponseEntity.ok().body(System.nanoTime());
    }

}
