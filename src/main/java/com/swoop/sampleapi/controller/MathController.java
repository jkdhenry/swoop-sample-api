package com.swoop.sampleapi.controller;

import com.swoop.sampleapi.model.MathRequest;
import com.swoop.sampleapi.model.MathResponse;
import com.swoop.sampleapi.service.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("math")
public class MathController {

    @Autowired
    private MathService mathService;


    /**
     * Web service endpoint to add two numbers together.
     *
     * If request parameters contain two numbers with the n1 and n2 names, the
     * result is returned as JSON with HTTP status 200.
     *
     * A 400 Bad Request will be returned if the either request parameter is
     * not provided.
     */
    @RequestMapping(method = RequestMethod.GET,
                    value = "/add",
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public MathResponse addNumbers(@RequestParam("n1") float firstNumber,
                                   @RequestParam("n2") float secondNumber) {
        return mathService.addNumbers(firstNumber, secondNumber);
    }

    /**
     * Web service endpoint to add two number together.
     *
     * The HTTP request body must contain two form params (firstNumber, secondNumber).
     * The result of adding these numbers will be returned as JSON.
     *
     * A 400 Bar request will be returned if the form params are not provided.
     */
    @RequestMapping(method = RequestMethod.POST,
                    value = "/add",
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public MathResponse addNumbers(@RequestBody MathRequest mathRequest) {
        return mathService.addNumbers(mathRequest.getFirstNumber(), mathRequest.getSecondNumber());
    }
}
