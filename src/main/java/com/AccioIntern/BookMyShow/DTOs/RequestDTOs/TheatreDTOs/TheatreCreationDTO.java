package com.AccioIntern.BookMyShow.DTOs.RequestDTOs.TheatreDTOs;

import lombok.*;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TheatreCreationDTO {
    private int noOfBalconySeats;
    private int noOfLowerSeats;
    private int noOfMiddleSeats;
    private String name;
    private String location;
}
