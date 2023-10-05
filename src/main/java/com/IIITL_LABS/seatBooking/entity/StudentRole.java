package com.IIITL_LABS.seatBooking.entity;

import com.IIITL_LABS.seatBooking.enums.Specialization;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class StudentRole extends UserRole {
  @Enumerated(EnumType.STRING) private Specialization specialization;
}
