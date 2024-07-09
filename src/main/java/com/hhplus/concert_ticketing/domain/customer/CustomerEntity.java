package com.hhplus.concert_ticketing.domain.customer;


import jakarta.persistence.*;
import lombok.*;



@Entity
@Table(name="customer")
@Builder
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

    public void updatePoint(Long point){
        this.point+=point;
    }//

}//end
