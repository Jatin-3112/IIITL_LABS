package com.IIITL_LABS.seatBooking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "seat",columnNames = {"seatNumber","lab_id"})
})
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer seatNumber;

    @ManyToOne
    @JoinColumn(name = "Lab_id")
    private Lab lab;
}
