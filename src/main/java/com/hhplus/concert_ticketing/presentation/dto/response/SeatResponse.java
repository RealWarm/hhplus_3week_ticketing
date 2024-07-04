package com.hhplus.concert_ticketing.presentation.dto.response;

import lombok.Getter;

@Getter
public class SeatResponse {
    Long seatId;
    String seatNumber;
    SeatStatus status;

    public SeatResponse(Long seatId, String seatNumber, SeatStatus status) {
        this.seatId = seatId;
        this.seatNumber = seatNumber;
        this.status = status;
    }
}
