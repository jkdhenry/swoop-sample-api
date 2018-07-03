package com.swoop.sampleapi.service;

import com.swoop.sampleapi.model.MathResponse;
import org.springframework.stereotype.Service;

@Service
public class MathService {

    public MathResponse addNumbers(float number1, float number2) {
        return new MathResponse(number1 + number2);
    }
}
