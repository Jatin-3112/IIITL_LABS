package com.IIITL_LABS.seatBooking.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "User",columnNames = {"seatNumber","lab_id"})
})
public class User {
    private String firstName;
    private String lastName;
    @Id
    private String email;
    @NonNull
    private String password;
    private Long phone;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id", nullable = false)
    private UserRole role;
}
