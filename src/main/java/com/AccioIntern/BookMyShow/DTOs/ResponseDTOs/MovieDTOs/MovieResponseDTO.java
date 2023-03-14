package com.AccioIntern.BookMyShow.DTOs.ResponseDTOs.MovieDTOs;

import com.AccioIntern.BookMyShow.Enums.MovieGenre;
import com.AccioIntern.BookMyShow.Enums.MovieLanguage;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieResponseDTO {
    private String name;
    private double rating;
    private double duration;
    private MovieLanguage movieLanguage;
    private MovieGenre movieGenre;
}
