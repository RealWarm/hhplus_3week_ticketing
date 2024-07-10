package com.hhplus.concert_ticketing.Token;


import com.hhplus.concert_ticketing.domain.Token.TokenEntity;
import com.hhplus.concert_ticketing.domain.Token.TokenRepository;
import com.hhplus.concert_ticketing.domain.Token.TokenStatus;
import com.hhplus.concert_ticketing.domain.customer.CustomerEntity;
import com.hhplus.concert_ticketing.domain.customer.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Transactional
@SpringBootTest
public class TokenRepositoryTest {

    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private CustomerRepository customerRespository;

    @BeforeEach
    void setUp() {
        int cntNum = 60;
        List<CustomerEntity> customers = new ArrayList<>();
        for (long i = 1; i <= cntNum+5; i++) {
            CustomerEntity customer = new CustomerEntity(i, "customer" + i, 10000L);
            customers.add(customer);
            customerRespository.save(customer);
        }
        /////////////////////////////////////////
        List<TokenEntity> tokens = new ArrayList<>();
        for (int i = 1; i <= cntNum; i++) {
            TokenEntity token = new TokenEntity(i + 1L, customers.get(i),  "TokenValue"+1,
                    i % 2 == 0 ? TokenStatus.ACTIVATE : TokenStatus.WAITING);
            tokens.add(token);
            tokenRepository.save(token);
        }
    }


    @Test
    void 토큰발행() {
        CustomerEntity customer1 = new CustomerEntity(1L, "customer1", 10000L);
        TokenEntity token1 = new TokenEntity(1L, customer1, "TokenValue1", TokenStatus.ACTIVATE);
        TokenEntity result = tokenRepository.save(token1);
        System.out.println("@@@@ " + result.getId());
    }


    @Test
    void 토큰검색_ByTokenId() {
        Optional<TokenEntity> token = tokenRepository.findById(1L);
        if (token != null) {
            System.out.println("@@@@@@@@@ " + token.get().getId());
        }
    }


    @Test
    void 토큰검색_ByTokenIdAndUserId() {
        Optional<TokenEntity> token = tokenRepository.findByIdAndCustomer_Id(1L, 1L);
        if (token != null) {
            System.out.println("@@@@@@@@@ " + token.get().toString());
        }
    }

    @Test
    void 토큰대기열번호_조회() {
        Long queuPosition = tokenRepository.countByIdLessThanAndStatus(40L, TokenStatus.WAITING);
        System.out.println("@@@@@@@@@@@ " + queuPosition);
    }


}
