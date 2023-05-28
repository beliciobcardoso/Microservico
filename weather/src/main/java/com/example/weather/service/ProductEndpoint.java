package com.example.weather.service;

import com.example.weather.model.DTO.ProductDTO;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "product-service")
@LoadBalancerClient(name = "product-service")
public interface ProductEndpoint {

    @RequestMapping(method = RequestMethod.GET, value = "/products/product")
    List<ProductDTO> getProductDTO();
}
