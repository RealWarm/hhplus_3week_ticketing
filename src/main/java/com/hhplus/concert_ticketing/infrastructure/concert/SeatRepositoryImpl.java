package com.hhplus.concert_ticketing.infrastructure.concert;

import com.hhplus.concert_ticketing.domain.concert.SeatEntity;
import com.hhplus.concert_ticketing.domain.concert.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class SeatRepositoryImpl implements SeatRepository {

    private final SeatJpaRepository seatJpaRepository;


    @Override
    public SeatEntity save(SeatEntity seat) {
        return seatJpaRepository.save(seat);
    }

    @Override
    public List<SeatEntity> findByConcertOption_Id(Long optionId) {
        return seatJpaRepository.findByConcertOption_Id(optionId);
    }

    @Override
    public Optional<SeatEntity> findByConcertOption_IdAndSeatNumber(Long optionId, String seatNumber) {
        return seatJpaRepository.findByConcertOption_IdAndSeatNumber(optionId, seatNumber);
    }
}
