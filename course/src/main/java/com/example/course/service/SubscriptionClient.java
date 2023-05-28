package com.example.course.service;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "SUBSCRIPTION-SERVICE")
@LoadBalancerClient(name = "SUBSCRIPTION-SERVICE")
public interface SubscriptionClient {

    @GetMapping("/subscription/port")
    String getPort();
}
