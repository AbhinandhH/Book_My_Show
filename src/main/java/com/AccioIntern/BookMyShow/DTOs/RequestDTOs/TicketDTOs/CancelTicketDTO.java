package com.AccioIntern.BookMyShow.DTOs.RequestDTOs.TicketDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CancelTicketDTO {
    private int userId;
    private int showId;
}
