package com.AccioIntern.BookMyShow.DTOs.RequestDTOs.TheatreDTOs;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TheatreCreationDTO {
    @NotBlank(message = "please provide number of balcony seats")
    private int noOfBalconySeats;
    @NotBlank(message = "please provide number of lower seats")
    private int noOfLowerSeats;
    @NotBlank(message = "please provide number of middle seats")
    private int noOfMiddleSeats;
    @NotBlank(message = "please enter the theatre name")
    private String name;
    @NotBlank(message = "please provide theatre location")
    private String location;
}
