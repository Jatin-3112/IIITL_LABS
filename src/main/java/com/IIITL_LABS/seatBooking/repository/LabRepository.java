package com.IIITL_LABS.seatBooking.repository;

import com.IIITL_LABS.seatBooking.entity.Lab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LabRepository extends JpaRepository<Lab, Long> {

    List<Lab> findAllByTheatreAndNameIn(Theatre theatre, List<String> screenRequests);

    Optional<Lab> findByIdAndTheatreId(Long id, Long theatreId);

    List<Lab> findAllByTheatreId(Long theatreId);
}
