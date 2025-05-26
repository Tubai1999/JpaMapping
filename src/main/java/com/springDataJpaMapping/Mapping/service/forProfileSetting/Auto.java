package com.springDataJpaMapping.Mapping.service.forProfileSetting;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class Auto implements Vehicle{

    @Override
    public void numberOfWheeles() {
        System.out.println("inside auto class");
    }
}
