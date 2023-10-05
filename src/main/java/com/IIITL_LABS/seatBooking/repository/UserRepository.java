package com.IIITL_LABS.seatBooking.repository;

import com.IIITL_LABS.seatBooking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
