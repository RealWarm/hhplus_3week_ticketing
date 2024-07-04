package com.hhplus.concert_ticketing.presentation.dto.response;

import lombok.Getter;


@Getter
public class ReservationRequest {
    Long userId;
    Long seatId;
    ReservationStatus status;
}
