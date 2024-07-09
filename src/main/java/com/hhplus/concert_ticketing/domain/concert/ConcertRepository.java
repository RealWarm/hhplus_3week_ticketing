package com.hhplus.concert_ticketing.domain.concert;


import java.util.Optional;

public interface ConcertRepository {

    // 콘서트 저장
    ConcertEntity save(ConcertEntity entity);

    // 콘서트 ID별 검색
    Optional<ConcertEntity> findById(Long id);

    // 콘서트 ID, 제목으로 조회
    Optional<ConcertEntity> findByIdAndName(Long id, String name);

}
