package com.hhplus.concert_ticketing.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PaymentResponse {
    Long paymentId;

    @Builder
    public PaymentResponse(Long paymentId) {
        this.paymentId = paymentId;
    }
}
