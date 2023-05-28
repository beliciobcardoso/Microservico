package com.example.weather.controller;

import com.example.weather.service.ProductEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private ProductEndpoint productEndpoint;

    @RequestMapping(method = RequestMethod.GET, path = "/weather-product")
    public ResponseEntity findAll() {
        return ResponseEntity.ok(productEndpoint.getProductDTO());
    }


}
