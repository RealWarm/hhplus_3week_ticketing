package com.hhplus.concert_ticketing.infrastructure.customer;

import com.hhplus.concert_ticketing.domain.customer.CustomerEntity;
import com.hhplus.concert_ticketing.domain.customer.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CustomerRepositoryImpl implements CustomerRepository {

    private final CustomerJpaRespository customerJpaRespository;

    @Override
    public CustomerEntity save(CustomerEntity entity) {
        return customerJpaRespository.save(entity);
    }

    @Override
    public Optional<CustomerEntity> findById(Long id) {
        return customerJpaRespository.findById(id);
    }

    @Override
    public Optional<CustomerEntity> findByIdAndUserName(Long id, String username) {
        return customerJpaRespository.findByIdAndUserName(id, username);
    }

}//end
