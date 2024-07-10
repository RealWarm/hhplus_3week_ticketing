package com.hhplus.concert_ticketing.infrastructure.Token;

import com.hhplus.concert_ticketing.domain.Token.TokenEntity;
import com.hhplus.concert_ticketing.domain.Token.TokenStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TokenJPARepository extends JpaRepository<TokenEntity, Long> {

    // @Query("SELECT t FROM TokenEntity t WHERE t.customerId = :customerId AND t.reservationId = :reservationId")
    Optional<TokenEntity> findByIdAndCustomer_Id(Long tokenId, Long customerId);

    Optional<TokenEntity> findByCustomer_Id(Long customerId);

    // @Query("SELECT COUNT(t) FROM TokenEntity t WHERE t.id < :id AND t.status = :status")
    Long countByIdLessThanAndStatus(Long id, TokenStatus status);

    List<TokenEntity> findByStatus(TokenStatus status);

}

