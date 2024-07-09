package com.hhplus.concert_ticketing.infrastructure.concert;

import com.hhplus.concert_ticketing.domain.concert.ConcertEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConcertJpaRepository extends JpaRepository<ConcertEntity, Long> {
    // 콘서트 ID, 제목으로 조회
    Optional<ConcertEntity> findByIdAndName(Long id, String name);
}
