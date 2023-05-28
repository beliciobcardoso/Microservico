package com.example.weather.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "open-weather-service", url = "https://api.openweathermap.org/data/2.5/weather?lat=-12.979714616221319&lon=-38.48877337900591&appid=32e11ac4692d5def1b7edbda69cc012f")
public interface OpenWeatherEndpoint {

    @RequestMapping(method = RequestMethod.GET, value = "")
    String getOpenWeatherSalvador();
}
