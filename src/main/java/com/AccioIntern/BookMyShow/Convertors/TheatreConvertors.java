package com.AccioIntern.BookMyShow.Convertors;

import com.AccioIntern.BookMyShow.DTOs.RequestDTOs.TheatreDTOs.TheatreCreationDTO;
import com.AccioIntern.BookMyShow.DTOs.ResponseDTOs.TheatreDTOs.TheatreResponseDTO;
import com.AccioIntern.BookMyShow.Enums.SeatType;
import com.AccioIntern.BookMyShow.Models.Theatre;
import com.AccioIntern.BookMyShow.Models.TheatreSeat;

import java.util.List;

public class TheatreConvertors {
    public static Theatre theatreCreationDtotoTheatre(TheatreCreationDTO theatreCreationDTO){
        Theatre theatre = Theatre.builder()
                .Location(theatreCreationDTO.getLocation())
                .name(theatreCreationDTO.getName())
                .build();
        return theatre;
    }

    public static TheatreResponseDTO theatreToTheatreResponseDTO(Theatre theatre){
        TheatreResponseDTO theatreResponseDTO = TheatreResponseDTO.builder()
                .location(theatre.getLocation())
                .name(theatre.getName())
                .build();
        return theatreResponseDTO;
    }
}
