package com.hhplus.concert_ticketing.presentation.dto.response;

import com.hhplus.concert_ticketing.domain.Token.TokenStatus;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TokenResponse {

    String tokenValue;
    TokenStatus tokenStatus;
    Long queuePosition;
    LocalDateTime expired_at;

    @Builder

    public TokenResponse(String tokenValue, TokenStatus tokenStatus,
                         Long queuePosition, LocalDateTime expired_at) {
        this.tokenValue = tokenValue;
        this.tokenStatus = tokenStatus;
        this.queuePosition = queuePosition;
        this.expired_at = expired_at;
    }
}
