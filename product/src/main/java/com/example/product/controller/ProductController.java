package com.example.product.controller;

import com.example.product.model.DTO.UserDTO;
import com.example.product.model.Product;
import com.example.product.service.ProductService;
import com.example.product.service.UserEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@RestController
@CrossOrigin("*")
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private UserEndpoint userEndpoint;

    private static AtomicInteger COUNT_CALL_GATEWAY = new AtomicInteger();

    @RequestMapping(method = RequestMethod.GET, path = "/product")
    public ResponseEntity findAll() {
        log.info("Resquest: " + COUNT_CALL_GATEWAY.incrementAndGet());
        return ResponseEntity.ok(productService.findAll());
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Product product) {
        return ResponseEntity.ok(productService.save(product));
    }

    @RequestMapping(method = RequestMethod.GET, path = "/user")
    public UserDTO getUserDTO() {
        log.info("Product-service consumindo o User-service na porta: " + userEndpoint.getUserDTO().getPort());
        return userEndpoint.getUserDTO();
    }


    @RequestMapping(method = RequestMethod.GET, path = "/message")
    public String getMessage() {
        return "Hello from product-service";
    }
}
