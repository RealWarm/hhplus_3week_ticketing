package com.hhplus.concert_ticketing.domain.Token;


import java.util.List;
import java.util.Optional;

public interface TokenRepository {

    // 토큰 발급
    TokenEntity save(TokenEntity token);

    // 토큰 조회
    Optional<TokenEntity> findById(Long tokenId);

    Optional<TokenEntity> findByCustomer_Id(Long customerId);
    Optional<TokenEntity> findByIdAndCustomer_Id(Long tokenId, Long customerId);

    // 현재 대기열 순번 조회 API
    Long countByIdLessThanAndStatus(Long id, TokenStatus status);

    // 토큰 status로 상태 조회
    List<TokenEntity> findByStatus(TokenStatus status);

    // 필요없을 것으로 판단 : 영속성 컨텍스트로 업데이트 가능
    // 토큰 최신화 : 토큰의 expired Time을 늘린다.
    // TokenEntity updateToken(TokenEntity token, Long addTime);

    // 필요없을 것으로 판단 : 영속성 컨텍스트로 업데이트 가능
    // 토큰 만료 : expiredTime의 시간이 지나서 status를 EXPIRED로 바꾼다.
    // Boolean expireToken(Long tokenId);

}// end
