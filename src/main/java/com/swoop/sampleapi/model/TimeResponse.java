package com.swoop.sampleapi.model;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class TimeResponse {

    private OffsetDateTime offsetDateTime;


    public TimeResponse(OffsetDateTime offsetDateTime) {
        this.offsetDateTime = offsetDateTime;
    }

    public long getEpochSeconds() {
        return offsetDateTime.toEpochSecond();
    }

    public OffsetDateTime getIsoDateTime() {
        return offsetDateTime;
    }

    public ZoneOffset getUtcOffset() {
        return offsetDateTime.getOffset();
    }

    public LocalDateTime getLocalDateTime() {
        return offsetDateTime.toLocalDateTime();
    }
}
