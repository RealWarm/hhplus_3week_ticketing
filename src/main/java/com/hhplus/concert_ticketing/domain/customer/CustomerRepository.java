package com.hhplus.concert_ticketing.domain.customer;

import java.util.Optional;

public interface CustomerRepository {

    // 회원정보 저장
    CustomerEntity save(CustomerEntity entity);

    // 회원 정보 조회
    Optional<CustomerEntity> findById(Long id);
    Optional<CustomerEntity> findByIdAndUserName(Long id, String username);


    // 회원 포인트 업데이트 : 영속성 컨텍스트로 !!!!

}
