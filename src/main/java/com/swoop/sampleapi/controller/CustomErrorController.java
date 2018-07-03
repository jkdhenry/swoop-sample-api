package com.swoop.sampleapi.controller;

import com.swoop.sampleapi.ApplicationServiceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


@RestController
public class CustomErrorController extends AbstractErrorController {

    private static final String PATH = "/error";

    @Autowired
    private ApplicationServiceProperties appConfig;

    public CustomErrorController(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }

    /**
     * Return any API errors as JSON responses.
     */
    @RequestMapping(value = PATH,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> handleError(HttpServletRequest request) {
        return super.getErrorAttributes(request, appConfig.isDebug());
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
