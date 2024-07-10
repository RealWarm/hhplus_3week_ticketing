package com.hhplus.concert_ticketing.service;


import com.hhplus.concert_ticketing.domain.Token.TokenEntity;
import com.hhplus.concert_ticketing.domain.Token.TokenRepository;
import com.hhplus.concert_ticketing.domain.Token.TokenStatus;
import com.hhplus.concert_ticketing.domain.customer.CustomerEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class TokenService {

    private final TokenRepository tokenRepository;

    // 토큰 발급
    // 토큰이 없으면 발급, 있으면 반환
    public TokenEntity issueToken(CustomerEntity customer){
        // 해당ID의 유저가 존재하니? >> 유저서비스로 확인 그래서 여기는 무조건 존재한다고 가정
        Optional<TokenEntity> userToken = tokenRepository.findByCustomer_Id(customer.getId());

        // 없으면 발급
        if (userToken.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            userToken = Optional.ofNullable(tokenRepository.save(TokenEntity.builder()
                    .id(1L)
                    .customer(customer)
                    .tokenValue(sb.append(customer.getUserName())
                                    .append(LocalDateTime.now().toString()).toString())
                    .status(TokenStatus.WAITING)
                    .createdAt(LocalDateTime.now())
                    .expiredAt(LocalDateTime.now())
                    .build()));
             System.out.println("발급된 토큰 값 :: " + userToken.get().getTokenValue());
             System.out.println("발급된 상태 값 :: " + userToken.get().getStatus());
        }//if

        return userToken.get();

    }//issueToken


    // 토큰 검증 : (active인지, expiredAt이 아직인지)




    // 대기열 조회 >> 내 앞에 얼마나 남아있니?



    // 토큰 만료시간 업데이트



    // 토큰 만료



}//end
