package com.hhplus.concert_ticketing.domain.concert;


import java.util.List;
import java.util.Optional;

public interface SeatRepository {

    // 콘서트 옵션별 좌석 저장
    SeatEntity save(SeatEntity seat);

    // 옵션ID로 모든 좌석 조회
    List<SeatEntity> findByConcertOption_Id(Long optionId);

    // 옵션ID와 좌석 번호로 좌석 조회
    Optional<SeatEntity> findByConcertOption_IdAndSeatNumber(Long optionId, String seatNumber);

}
