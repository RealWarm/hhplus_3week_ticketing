package com.hhplus.concert_ticketing.infrastructure.concert;

import com.hhplus.concert_ticketing.domain.concert.ConcertOptionEntity;
import com.hhplus.concert_ticketing.domain.concert.ConcertOptionRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ConcertOptionJpaRepository extends JpaRepository<ConcertOptionEntity, Long> {
    // 콘서트 id별 예약 가능한 날짜 조회(=옵션 통째 조회)
    List<ConcertOptionEntity> findByConcert_Id(Long id);
}
