package com.AccioIntern.BookMyShow.DTOs.RequestDTOs.TicketDTOs;

import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "showId should be given")
    private int showId;
    @NotBlank(message = "userId should be given")
    private int userId;
    @NotBlank(message = "please enter the seates required")
    private List<String> requiredSeats = new ArrayList<>();
}
