package com.AccioIntern.BookMyShow.DTOs.RequestDTOs.ShowDTOs;

import com.AccioIntern.BookMyShow.Enums.ShowTypes;
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
public class ShowCreationDTO {
     private LocalDate showDate;
     private LocalTime showTime;
     private ShowTypes showType;
     private int lowerSeatPrice;
     private int middleSeatPrice;
     private int balconySeatPrice;
     private int twoDShowPrice;
     private int threeDShowPrice;
     private int theatreId;
     private int movieId;
}
