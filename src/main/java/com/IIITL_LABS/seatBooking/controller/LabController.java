package com.movienow.org.controller;


import com.IIITL_LABS.seatBooking.service.LabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1")
public class LabController {
    @Autowired
    private LabService labService;


    @PreAuthorize("hasAuthority('ADMIN') OR hasAuthority('STUDENT')")
    @GetMapping("/labs")
    public ResponseEntity<Object> getScreens() {
        return ResponseEntity.ok().body(labService.getLabs(labId));
    }

    @PreAuthorize("hasAuthority('ADMIN') OR hasAuthority('STUDENT')")
    @GetMapping("/labs")
    public ResponseEntity<Object> getScreens(@PathVariable(value = "labId") final Long labid) {
        return ResponseEntity.ok().body(labService.getLab(labId));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/cities/theatres/{theatreId}/screens")
    public ResponseEntity<Object> addScreens(@PathVariable(value = "labId") final Long labId,
                                             @RequestBody List<Seats> screenRequests) {
        return ResponseEntity.ok().body(labService.addLabs(labId, screenRequests));
    }
}