package com.example.course.service.impl;

import com.example.course.service.CourseService;
import com.example.course.service.SubscriptionClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl  implements CourseService {

    @Autowired
    private SubscriptionClient subscriptionService;

    @Override
    public String getSubscriptionPort() {
        var port = subscriptionService.getPort();
        System.out.println(port);
        return port;
    }
}
