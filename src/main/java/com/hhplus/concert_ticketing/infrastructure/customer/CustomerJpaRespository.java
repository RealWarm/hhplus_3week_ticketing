package com.hhplus.concert_ticketing.infrastructure.customer;

import com.hhplus.concert_ticketing.domain.customer.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerJpaRespository extends JpaRepository<CustomerEntity, Long> {

    Optional<CustomerEntity> findByIdAndUserName(Long id, String userName);

}
