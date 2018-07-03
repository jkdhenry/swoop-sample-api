package com.swoop.sampleapi.gateway.time.result;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class CurrentTimeResult {

    private CurrentTimeData data;

    public CurrentTimeData getData() {
        return data;
    }

    public void setData(CurrentTimeData data) {
        this.data = data;
    }
}
