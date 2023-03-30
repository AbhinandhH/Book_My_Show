package com.AccioIntern.BookMyShow.DTOs.RequestDTOs.MovieDTOs;

import com.AccioIntern.BookMyShow.Enums.MovieGenre;
import com.AccioIntern.BookMyShow.Enums.MovieLanguage;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieCreationDTO {
    @Min(value = 1, message = "rating should be greater than or equal to 1")
    @Max(value = 5, message = "rating should be lesser than or equal to 5")
    private double rating;
    @NotBlank(message = "Name should be given")
    private String name;
    @NotBlank(message = "Movie language should be given")
    private MovieLanguage movieLanguage;
    @NotBlank(message = "Movie Genre should be given")
    private MovieGenre movieGenre;
    private double duration;
}
