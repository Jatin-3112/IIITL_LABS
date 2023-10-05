package com.IIITL_LABS.seatBooking.entity;

import com.IIITL_LABS.seatBooking.enums.LabType;
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
        @UniqueConstraint(name = "Labs",columnNames = {"labNumber","screen_id"})
})
public class Lab {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer labNumber;

    @Enumerated(EnumType.STRING)
    private LabType labType;
}
