package com.hhplus.concert_ticketing.service;


import com.hhplus.concert_ticketing.domain.Token.TokenEntity;
import com.hhplus.concert_ticketing.domain.Token.TokenRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TokenService {

    private final TokenRepository tokenRepository;

    // 토큰 발급
    // 토큰이 없으면 발급
    // 토큰이 있으면 대기열 최신화 후 발급
    public TokenEntity issueToken(Long customerId, Long reservationId){

        return null;
    }//issueToken

    // 대기열 조회

    // 토큰 만료시간 업데이트

    // 토큰 만료

}//end
