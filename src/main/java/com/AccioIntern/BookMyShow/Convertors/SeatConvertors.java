package com.AccioIntern.BookMyShow.Convertors;

import com.AccioIntern.BookMyShow.DTOs.RequestDTOs.ShowDTOs.ShowCreationDTO;
import com.AccioIntern.BookMyShow.Enums.SeatType;
import com.AccioIntern.BookMyShow.Models.Show;
import com.AccioIntern.BookMyShow.Models.ShowSeat;
import com.AccioIntern.BookMyShow.Models.TheatreSeat;

public class SeatConvertors {
    public static ShowSeat theatreSeatToShowSeat(TheatreSeat theatreSeat, Show show, ShowCreationDTO showCreationDTO){
        ShowSeat showSeat = ShowSeat.builder()
                .seatNo(theatreSeat.getSeatNo())
                .shows(show)
                .seatType(theatreSeat.getSeatType())
                .seatPrice(seatPriceSelector(theatreSeat, showCreationDTO))
                .build();
        return showSeat;
    }

    private static int seatPriceSelector(TheatreSeat theatreSeat, ShowCreationDTO showCreationDTO){
        if(theatreSeat.getSeatType().equals(SeatType.BALCONY)){
            return showCreationDTO.getBalconySeatPrice();
        }else if(theatreSeat.getSeatType().equals(SeatType.MIDDLE)){
            return showCreationDTO.getMiddleSeatPrice();
        }else{
            return showCreationDTO.getLowerSeatPrice();
        }
    }
}
