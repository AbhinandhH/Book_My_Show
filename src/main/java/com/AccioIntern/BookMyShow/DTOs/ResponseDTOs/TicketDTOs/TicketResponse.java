package com.AccioIntern.BookMyShow.DTOs.ResponseDTOs.TicketDTOs;

import com.AccioIntern.BookMyShow.Models.Show;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TicketResponse {
    private int totalAmount;
    private String movieName;
    private String ticketId;
    private LocalDate showDate;
    private LocalTime showTime;
    private String theatreName;
    private String bookedSeats;
    private Show thisShow;
}
