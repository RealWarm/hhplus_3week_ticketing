package com.hhplus.concert_ticketing.domain.Token;


import com.hhplus.concert_ticketing.domain.customer.CustomerEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "token")
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TokenEntity {

    @Id
    @Column(nullable = false, name = "token_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    // Token 테이블에는 customer_id라는 열이 존재하며,
    // 이는 Customer 테이블의 customer_id와 매핑됨
    private CustomerEntity customer;

    private String tokenValue;

    @Enumerated(EnumType.STRING)
    private TokenStatus status;

    // 필드는 언더바 안쓰기
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();

    @Builder.Default
    private LocalDateTime expiredAt = LocalDateTime.now();

    public TokenEntity(Long id, CustomerEntity customer,
                       String tokenValue, TokenStatus status) {
        this.id = id;
        this.customer = customer;
        this.tokenValue = tokenValue;
        this.status = status;
        this.createdAt = LocalDateTime.now();
        this.expiredAt = LocalDateTime.now();
    }//init

}//end