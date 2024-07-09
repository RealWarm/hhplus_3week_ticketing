package com.hhplus.concert_ticketing.domain.concert;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@Table(name="seat")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SeatEntity {

    @Id
    @Column(nullable = false, name="seat_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "concert_option_id")
    private ConcertOptionEntity concertOption;

    private String seatNumber;

    @Enumerated(EnumType.STRING)
    private SeatStatus status;

}