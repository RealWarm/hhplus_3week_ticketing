package com.hhplus.concert_ticketing.infrastructure.concert;

import com.hhplus.concert_ticketing.domain.concert.ConcertEntity;
import com.hhplus.concert_ticketing.domain.concert.ConcertOptionEntity;
import com.hhplus.concert_ticketing.domain.concert.ConcertOptionRepository;
import com.hhplus.concert_ticketing.domain.concert.ConcertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ConcertOptionRepositoryImpl implements ConcertOptionRepository {

    private final ConcertOptionJpaRepository concertOptionJpaRepository;

    @Override
    public ConcertOptionEntity save(ConcertOptionEntity entity) {
        return concertOptionJpaRepository.save(entity);
    }

    @Override
    public Optional<ConcertOptionEntity> findById(Long id) {
        return concertOptionJpaRepository.findById(id);
    }

    @Override
    public List<ConcertOptionEntity> findByConcert_Id(Long id) {
        return concertOptionJpaRepository.findByConcert_Id(id);
    }
}
