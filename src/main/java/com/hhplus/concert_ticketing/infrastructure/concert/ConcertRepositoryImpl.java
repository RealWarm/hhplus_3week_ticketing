package com.hhplus.concert_ticketing.infrastructure.concert;

import com.hhplus.concert_ticketing.domain.concert.ConcertEntity;
import com.hhplus.concert_ticketing.domain.concert.ConcertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ConcertRepositoryImpl implements ConcertRepository {

    private final ConcertJpaRepository concertJpaRepository;


    @Override
    public ConcertEntity save(ConcertEntity entity) {
        return concertJpaRepository.save(entity);
    }

    @Override
    public Optional<ConcertEntity> findById(Long id) {
        return concertJpaRepository.findById(id);
    }

    @Override
    public Optional<ConcertEntity> findByIdAndName(Long id, String name) {
        return findByIdAndName(id, name);
    }

}
