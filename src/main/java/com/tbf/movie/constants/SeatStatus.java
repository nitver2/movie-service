package com.tbf.movie.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SeatStatus {
    AVAILABLE("available"),
    BOOKED("booked"),
    RESERVED("reserved");

    private final String status;

    SeatStatus(String status) {
        this.status = status;
    }

    @JsonValue
    public String getStatus() {
        return status;
    }

    @JsonCreator
    public static SeatStatus fromString(String status) {
        for (SeatStatus seatStatus : SeatStatus.values()) {
            if (seatStatus.getStatus().equalsIgnoreCase(status)) {
                return seatStatus;
            }
        }
        throw new IllegalArgumentException("Unknown status: " + status);
    }
}
