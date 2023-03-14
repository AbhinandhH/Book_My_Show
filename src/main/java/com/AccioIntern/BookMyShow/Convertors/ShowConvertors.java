package com.AccioIntern.BookMyShow.Convertors;

import com.AccioIntern.BookMyShow.DTOs.RequestDTOs.ShowDTOs.ShowCreationDTO;
import com.AccioIntern.BookMyShow.Models.Show;
import com.AccioIntern.BookMyShow.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ShowConvertors {
    public static Show showCreationDtoToShow(ShowCreationDTO showCreationDTO){
        Show show = Show.builder()
                .showDate(showCreationDTO.getShowDate())
                .showTime(showCreationDTO.getShowTime())
                .showType(showCreationDTO.getShowType())
                .build();
        return show;
    }
}
