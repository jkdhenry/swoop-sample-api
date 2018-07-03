package com.swoop.sampleapi.service;

import com.swoop.sampleapi.gateway.time.CurrentTimeGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class TimeService {

    @Autowired
    private CurrentTimeGateway currentTimeGateway;

    public OffsetDateTime getMSTCurrentTime() {
        return currentTimeGateway.getCurrentTime();
    }
}
