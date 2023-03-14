package com.AccioIntern.BookMyShow.DTOs.RequestDTOs.MovieDTOs;

import com.AccioIntern.BookMyShow.Enums.MovieGenre;
import com.AccioIntern.BookMyShow.Enums.MovieLanguage;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieCreationDTO {
    private double rating;
    private String name;
    private MovieLanguage movieLanguage;
    private MovieGenre movieGenre;
    private double duration;
}
