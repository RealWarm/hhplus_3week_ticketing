package com.hhplus.concert_ticketing.infrastructure.concert;

import com.hhplus.concert_ticketing.domain.concert.SeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SeatJpaRepository extends JpaRepository<SeatEntity, Long> {

    // 옵션ID로 모든 좌석 조회
    // select * from Seat where concert_option_id = :OptionId
    List<SeatEntity> findByConcertOption_Id(Long optionId);

    // 옵션ID와 좌석 번호로 좌석 조회
    // select * from Seat where concert_option_id = :OptionId And
    Optional<SeatEntity> findByConcertOption_IdAndSeatNumber(Long optionId, String seatNumber);

}
