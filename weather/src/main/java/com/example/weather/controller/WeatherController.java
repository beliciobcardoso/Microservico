package com.example.weather.controller;

import com.example.weather.service.OpenWeatherEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
@CrossOrigin("*")
public class WeatherController {
    @Autowired
    OpenWeatherEndpoint openWeatherEndpoint;

    @RequestMapping(method = RequestMethod.GET, path = "/weather-salvador")
    public String getOpenWeatherSalvador() {

        return openWeatherEndpoint.getOpenWeatherSalvador();
    }


}
