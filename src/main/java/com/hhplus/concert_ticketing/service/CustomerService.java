package com.hhplus.concert_ticketing.service;


import com.hhplus.concert_ticketing.domain.customer.CustomerEntity;
import com.hhplus.concert_ticketing.domain.customer.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    // 유저반환 > 없으면 예외 발생
    public CustomerEntity getCustomer(Long customerId){
        CustomerEntity customer = customerRepository.findById(customerId)
                .orElseThrow(()-> new NoSuchElementException("해당 ID의 유저가 없습니다."));
        return customer;
    }//getCustomer

    // 포인트 조회 > id로 유저 검색후 포인트 반환
    public Long getCustomerPoint(Long customerId){
        CustomerEntity customer = customerRepository.findById(customerId)
                .orElseThrow(()-> new NoSuchElementException("해당 ID의 유저가 없습니다."));
        return customer.getPoint();
    }

    // 포인트 충전 > 충전 후 잔액 반환
    public Long chargePoint(Long customerId, Long chargePoint){
        CustomerEntity customer = customerRepository.findById(customerId)
                .orElseThrow(()-> new NoSuchElementException("해당 ID의 유저가 없습니다."));
        return customer.chargePoint(chargePoint);
    }//chargePoint

}//end
