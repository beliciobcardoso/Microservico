package com.example.product.service;

import com.example.product.custom.CustomLoadBalancerConfig;
import com.example.product.model.DTO.UserDTO;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("user-service")
@LoadBalancerClient(name = "user-service" ,configuration = CustomLoadBalancerConfig.class)
public interface UserEndpoint {

    @RequestMapping(method = RequestMethod.GET, value = "/users/user")
    UserDTO getUserDTO();
}
