package com.AccioIntern.BookMyShow.DTOs.RequestDTOs.ShowDTOs;

import com.AccioIntern.BookMyShow.Enums.ShowTypes;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShowCreationDTO {
     @NotBlank(message = "show date should be given")
     private LocalDate showDate;
     @NotBlank(message = "show time should be given")
     private LocalTime showTime;
     @NotBlank(message = "show type should be given")
     private ShowTypes showType;
     @NotBlank(message = "please enter the lower seat price")
     private int lowerSeatPrice;
     @NotBlank(message = "please enter the middle seat price")
     private int middleSeatPrice;
     @NotBlank(message = "please enter the balcony seat price")
     private int balconySeatPrice;
     private int twoDShowPrice;
     private int threeDShowPrice;
     @NotBlank(message = "provide theatreId")
     private int theatreId;
     @NotBlank(message = "provide movieId")
     private int movieId;
}
