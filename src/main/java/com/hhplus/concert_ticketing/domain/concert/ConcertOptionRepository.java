package com.hhplus.concert_ticketing.domain.concert;

import java.util.List;
import java.util.Optional;

public interface ConcertOptionRepository {

    // 콘서트 옵션 저장
    ConcertOptionEntity save(ConcertOptionEntity entity);

    Optional<ConcertOptionEntity> findById(Long id);

    // 콘서트 id별 예약 가능한 날짜 조회(=옵션 통째 조회)
    List<ConcertOptionEntity> findByConcert_Id(Long id);


}
