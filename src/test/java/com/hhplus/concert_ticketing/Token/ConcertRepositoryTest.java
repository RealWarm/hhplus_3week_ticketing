package com.hhplus.concert_ticketing.Token;


import com.hhplus.concert_ticketing.domain.concert.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Transactional
@SpringBootTest
public class ConcertRepositoryTest {

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private ConcertRepository concertRepository;

    @Autowired
    private ConcertOptionRepository concertOptionRepository;

    @BeforeEach
    void setUp() {
        ConcertEntity concert = new ConcertEntity(1L, "미녀와 야수");
        ConcertEntity concert2 = new ConcertEntity(2L, "미녀와 야수2");
        ConcertEntity result = concertRepository.save(concert);
        /////////////////////////////////////////
        ConcertOptionEntity concertOption = new ConcertOptionEntity(1L, concert,
                LocalDateTime.now(),
                130000L
                );
        ConcertOptionEntity concertOption1 = new ConcertOptionEntity(2L, concert,
                LocalDateTime.now(),
                120000L
        );
        ConcertOptionEntity resultOption = concertOptionRepository.save(concertOption);
//        ConcertOptionEntity resultOption2 = concertOptionRepository.save(concertOption1);
        /////////////////////////////////////////
        int seatNum = 50;
        List<SeatEntity> seats = new ArrayList<>();
        for (long i = 1; i <= seatNum; i++) {
            SeatEntity seat = new SeatEntity(i, concertOption, String.valueOf(i),
                i%2==0 ? SeatStatus.AVAILABLE : SeatStatus.RESERVED
            );
            seats.add(seat);
            seatRepository.save(seat);
        }//for-i
    }//SETUP

    @Test
    void 콘서트옵션ID로_모든좌석_조회(){
        List<SeatEntity> seats = seatRepository.findByConcertOption_Id(1L);
        for (SeatEntity seat:
             seats) {
            System.out.println(seat.getSeatNumber()+" :: "+seat.getStatus());
        }
    }

    @Test
    void 콘서트옵션ID와_좌석번호로_좌석조회(){
        // findByConcertOption_IdAndSeatNumber
        Optional<SeatEntity> seat
                = seatRepository.findByConcertOption_IdAndSeatNumber(1L, "3");
        System.out.println("##### " + seat.get().getSeatNumber());
    }

    @Test
    void 콘서트ID로_모든콘서트옵션_조회(){
        List<ConcertOptionEntity> options =
                concertOptionRepository.findByConcert_Id(2L);
        for (int i = 0; i < options.size(); i++) {
            System.out.println("########### " + options.get(i).getId() + " || "
                    + options.get(i).getConcert().getName());
        }//for-i
    }





}//END
