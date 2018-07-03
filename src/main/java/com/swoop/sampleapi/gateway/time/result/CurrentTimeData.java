package com.swoop.sampleapi.gateway.time.result;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown=true)
public class CurrentTimeData {

    @JsonProperty("time_zone")
    private List<CurrentTimeZoneData> timeZone;

    public List<CurrentTimeZoneData> getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(List<CurrentTimeZoneData> timeZone) {
        this.timeZone = timeZone;
    }
}
