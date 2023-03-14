package com.AccioIntern.BookMyShow.Convertors;

import com.AccioIntern.BookMyShow.DTOs.RequestDTOs.MovieDTOs.MovieCreationDTO;
import com.AccioIntern.BookMyShow.DTOs.ResponseDTOs.MovieDTOs.MovieResponseDTO;
import com.AccioIntern.BookMyShow.Models.Movie;

public class MovieConvertors {
    public static Movie movieCreationDtoToMovie(MovieCreationDTO movieCreationDTO){
        Movie movie = Movie.builder().
                movieLanguage(movieCreationDTO.getMovieLanguage()).
                movieGenre(movieCreationDTO.getMovieGenre()).
                rating(movieCreationDTO.getRating()).
                duration(movieCreationDTO.getDuration()).
                name(movieCreationDTO.getName()).build();

        return movie;
    }

}
