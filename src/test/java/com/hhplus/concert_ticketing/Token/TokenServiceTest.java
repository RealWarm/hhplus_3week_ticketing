package com.hhplus.concert_ticketing.Token;


import com.hhplus.concert_ticketing.domain.Token.TokenEntity;
import com.hhplus.concert_ticketing.domain.Token.TokenRepository;
import com.hhplus.concert_ticketing.domain.Token.TokenStatus;
import com.hhplus.concert_ticketing.domain.customer.CustomerEntity;
import com.hhplus.concert_ticketing.domain.customer.CustomerRepository;
import com.hhplus.concert_ticketing.service.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@Transactional
@SpringBootTest
public class TokenServiceTest {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TokenRepository tokenRepository;


    @BeforeEach
    void setUp() {
        int cntNum = 60;
        List<CustomerEntity> users = new ArrayList<>();
        for (long i = 1; i <= cntNum + 5; i++) {
            CustomerEntity user = new CustomerEntity(i, "user" + i, 10000L);
            users.add(user);
            customerRepository.save(user);
        }
        //////////////////////////////////////
        int tokenNum = 40;
        for (long i = 1; i <= tokenNum; i++) {
            int userId = (int) i;
            TokenEntity token = new TokenEntity(i, users.get(userId), "TokenValue" + i, TokenStatus.WAITING);
            tokenRepository.save(token);
        }//for-i
    }


    @Test
    void 토큰_없으면_발급() {
        // 유저에 해당하는 토큰이 있으면 반환 || 없으면 생성후 반환
        // 유저 존재 체크는 UserService에서 확인 할 것이므로 유저는 반드시 존재한다 가정
        // 토큰이 없는 유저 생성
        CustomerEntity customer = new CustomerEntity(55L, "TokenValue55", 0L);
        TokenEntity result = tokenService.issueToken(customer);
        Assertions.assertThat(result.getStatus()).isEqualTo(TokenStatus.WAITING);
    }//토큰_없으면_발급

    @Test // 네가 가진 토큰이 유요한 토큰이니???
    void 토큰_검증() { // 좌석 예약, 날짜조회 할떄 사용예정
        // 현재 상태가 active여야함
        // expiredAt이 아직 이라면 True 반환,
        // 만료됐다면 false 반환


    }


    @Test
    void 대기열_조회(){

    }


    @Test
    void 토큰_만료시간_업데이트(){

    }


    // 토큰이 웨이팅일 때는 만료시간도 받지 못해서 만료를 못 시킴
    // 상태="액티브" && expiredAt>now()(시간지남) 일 때만 만료시킴
    @Test
    void 토큰_만료시_상태_변경() { //스케줄러 (1)
        // 상태가 액티브인 토큰들 모두 가져옴
        // 각각 [ 상태="액티브" && expiredAt>now()(시간지남) ] 인지 확인
        // 맞으면 status를 expired로 바꿈

        // 토큰 전체 조회 > 상태검사 > 만료처리

    }

}
//// 스케줄러 구성
//1. 토큰 만료시키기
//2. 예약 & 임시배정 좌석 만료시키기
//    네넵 맞습니다.