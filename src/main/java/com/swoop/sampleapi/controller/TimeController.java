package com.swoop.sampleapi.controller;

import com.swoop.sampleapi.model.TimeResponse;
import com.swoop.sampleapi.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("time")
public class TimeController {

    @Autowired
    private TimeService timeService;

    /**
     * Web service endpoint to return the current time for MST.
     */
    @RequestMapping(method = RequestMethod.GET,
                    value = "/now",
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public TimeResponse getCurrentTime() {
        return new TimeResponse(timeService.getMSTCurrentTime());
    }
}
