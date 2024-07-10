package com.hhplus.concert_ticketing.domain.reservation;


import com.hhplus.concert_ticketing.domain.concert.SeatEntity;
import com.hhplus.concert_ticketing.domain.concert.SeatStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name="reservation")
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReservationEntity {

    @Id
    @Column(nullable = false, name="reservation_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    @ManyToOne
    @JoinColumn(name="seat_id")
    // Reservation 테이블에는 seat_id라는 열이 존재하며
    // 이는 SeatEntity 테이블의 seat_id와 매핑됨
    private SeatEntity seat;

    private ReservationStatus status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public void changeStatus(ReservationStatus reservationStatus){
        this.status=reservationStatus;
    }


}//end
