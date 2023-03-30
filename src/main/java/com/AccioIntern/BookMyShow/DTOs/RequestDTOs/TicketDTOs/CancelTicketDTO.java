package com.AccioIntern.BookMyShow.DTOs.RequestDTOs.TicketDTOs;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CancelTicketDTO {
    @NotBlank(message = "userId should not be blank")
    private int userId;
    @NotBlank(message = "showId should not be blank")
    private int showId;
}
