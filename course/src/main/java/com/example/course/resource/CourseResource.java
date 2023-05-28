package com.example.course.resource;

import com.example.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseResource {

    @Autowired
    private CourseService service;

    @GetMapping
    public ResponseEntity<String> getCourse(){
        return new ResponseEntity<>("Rota principal", HttpStatus.OK);
    }

    @GetMapping("/subscription/port")
    public ResponseEntity<String> getSubscriptionPort(){
        return ResponseEntity.ok(service.getSubscriptionPort());
    }
}
