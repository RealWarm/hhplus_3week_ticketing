package com.hhplus.concert_ticketing.domain.concert;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@Table(name="concert_option")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ConcertOptionEntity {

    @Id
    @Column(nullable = false, name="concert_option_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "concert_id")
    // ConcertOption테이블에는 concert_id라는 열이 존재하며
    // 이는 Concert테이블의 concert_id와 매핑됨
    private ConcertEntity concert;

    private LocalDateTime concert_date;

    private Long price;


}