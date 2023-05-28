package com.example.subscription.resource;

import com.example.subscription.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subscription")
public class SubscriptionResource {

    @Autowired
    private SubscriptionService service;


    @GetMapping("/port")
    public ResponseEntity<String> getPort(){
        return ResponseEntity.ok(service.getPort());
    }
}
