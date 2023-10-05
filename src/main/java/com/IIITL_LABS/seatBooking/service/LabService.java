package com.movienow.org.service;

import com.IIITL_LABS.seatBooking.entity.Lab;
import com.IIITL_LABS.seatBooking.repository.SeatRepository;
import com.movienow.org.dto.AddScreenRequest;
import com.movienow.org.dto.ScreenDetailsDto;
import com.movienow.org.dto.ScreenResponse;
import com.movienow.org.dto.TheatreResponse;
import com.movienow.org.entity.Screen;
import com.movienow.org.entity.Theatre;
import com.movienow.org.exception.BadRequestException;
import com.movienow.org.exception.NotFoundException;
import com.movienow.org.repository.MovieRepository;
import com.movienow.org.repository.LabRepository;
import com.movienow.org.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LabService {
    @Autowired
    private LabRepository labRepository;
    @Autowired
    private SeatRepository seatRepository;


    /**
     * Used to get all Lab for a Theatre
     *
     * @param theatreId
     * @return
     */
    public List<LabDetailsDto> getLabs(Long theatreId) {
        theatreRepository.findById(theatreId).orElseThrow(() -> new NotFoundException("Theatre not found for given Id."));
        List<Lab> Labs = LabRepository.findAllByTheatreId(theatreId);
        return Labs.stream().map(this::getLabDetails).toList();
    }

    /**
     * Used to get LabDetails
     *
     * @param Lab
     * @return
     */
    private LabDetailsDto getLabDetails(Lab Lab) {
        LabDetailsDto LabDetails = new LabDetailsDto();
        LabDetails.setId(Lab.getId());
        LabDetails.setName(Lab.getName());
        return LabDetails;
    }

    /**
     * Used to add Labs to a particular Theatre
     *
     * @param theatreId
     * @param LabRequests
     * @return
     */
    public String addLabs(Long theatreId, List<AddLabRequest> LabRequests) {
        Theatre theatre = theatreRepository.findById(theatreId).orElseThrow(() -> new NotFoundException("Theatre not found with given Id."));
        List<String> LabNames = LabRequests.stream().map(AddLabRequest::getName).toList();
        List<Lab> existLabs = LabRepository.findAllByTheatreAndNameIn(theatre, LabNames);
        if (!existLabs.isEmpty()) {
            throw new BadRequestException("Some of the requested Labs to be added already exist in the Theatre");
        }
        List<Lab> Labs = new ArrayList<>();
        LabRequests.forEach(addLabRequest -> {
            Lab Lab = new Lab();
            Lab.setName(addLabRequest.getName());
            Lab.setTheatre(theatre);
            Labs.add(Lab);
        });
        labRepository.saveAll(Labs);
        return "Labs Added successfully.";
    }
}