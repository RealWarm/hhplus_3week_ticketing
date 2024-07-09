package com.hhplus.concert_ticketing.infrastructure.Token;

import com.hhplus.concert_ticketing.domain.Token.TokenEntity;
import com.hhplus.concert_ticketing.domain.Token.TokenRepository;
import com.hhplus.concert_ticketing.domain.Token.TokenStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TokenRepositoryImpl implements TokenRepository {

    private final TokenJPARepository tokenJpaRepository;

    @Override
    public TokenEntity save(TokenEntity token) {
        return tokenJpaRepository.save(token);
    }

    @Override
    public Optional<TokenEntity> findById(Long tokenId) {
        return tokenJpaRepository.findById(tokenId);
    }

    @Override
    public Optional<TokenEntity> findByIdAndCustomer_Id(Long tokenId, Long customerId) {
         return tokenJpaRepository.findByIdAndCustomer_Id(tokenId, customerId);
        //return null;
    }

    @Override
    public Long countByIdLessThanAndStatus(Long id, TokenStatus status) {
        return tokenJpaRepository.countByIdLessThanAndStatus(id, status);
    }

}
