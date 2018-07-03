package com.swoop.sampleapi.gateway.time;

import com.swoop.sampleapi.gateway.time.result.CurrentTimeData;
import com.swoop.sampleapi.gateway.time.result.CurrentTimeResult;
import com.swoop.sampleapi.gateway.time.result.CurrentTimeZoneData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Service
public class CurrentTimeGateway {

    @Value("${timeapiuri}")
    private String uri;

    @Value("${timeapikey}")
    private String apiKey;

    @Value("${timeapilocation}")
    private String location;

    private CurrentTimeZoneData makeRequest() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("apiKey", apiKey);
        params.put("location", location);

        RestTemplate restTemplate = new RestTemplate();
        CurrentTimeResult currentTimeResult = restTemplate.getForObject(uri, CurrentTimeResult.class, params);

        return currentTimeResult.getData().getTimeZone().get(0);
    }

    private int getUtcOffsetHour(String utcoffset) {
        if (utcoffset != null) {
            String[] splitOffset = utcoffset.split("\\.");
            return Integer.parseInt(splitOffset[0]);
        }
        return 0;
    }

    private int getUtcoffsetMinute(String utcoffset) {
        if (utcoffset != null) {
            String[] splitOffset = utcoffset.split("\\.");
            return Integer.parseInt(splitOffset[1]);
        }
        return 0;
    }

    private OffsetDateTime buildDateTime(CurrentTimeZoneData currentTimeZoneData) {
        String utcoffset = currentTimeZoneData.getUtcOffset();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd kk:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(currentTimeZoneData.getLocaltime(), dateTimeFormatter);
        ZoneOffset zoneOffset = ZoneOffset.ofHoursMinutes(getUtcOffsetHour(utcoffset), getUtcoffsetMinute(utcoffset));

        return localDateTime.atOffset(zoneOffset);
    }

    public OffsetDateTime getCurrentTime() {
        CurrentTimeZoneData currentTimeZoneData = this.makeRequest();

        return buildDateTime(currentTimeZoneData);
    }
}
