package com.hhplus.concert_ticketing.domain.customer;


import jakarta.persistence.*;
import lombok.*;



@Entity
@Table(name="customer")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CustomerEntity {

    @Id
    @Column(nullable = false, name="customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "username")
    private String userName;

    @Column(nullable = false, name="point")
    private Long point;

    public Long chargePoint(Long point){
        if(point<=0){
            throw new RuntimeException("포인트는 0원보다 커야합니다");
        }
        this.point+=point;
        return this.point;
    }//

}//end
