package com.hhplus.concert_ticketing.domain.reservation;


import com.hhplus.concert_ticketing.domain.concert.SeatEntity;
import jakarta.persistence.*;
import lombok.*;

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

    @ManyToOne
    @JoinColumn(name="seat_id")
    // Reservation 테이블에는 seat_id라는 열이 존재하며
    // 이는 SeatEntity 테이블의 seat_id와 매핑됨
    private SeatEntity seat;

    public enum Status {
        RESERVED,
        PAID,
        CANCELED
    }


}//end
