package com.hhplus.concert_ticketing.presentation.dto.request;

import com.hhplus.concert_ticketing.presentation.dto.response.ReservationStatus;
import lombok.Getter;


@Getter
public class ReservationRequest {
    Long userId;
    Long seatId;
    String Token;
    Long concertOptionId;

}
