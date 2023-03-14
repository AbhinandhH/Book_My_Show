package com.AccioIntern.BookMyShow.DTOs.RequestDTOs.TicketDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TicketBookingDTO {
    private int showId;
    private int userId;
    private List<String> requiredSeats = new ArrayList<>();
}
