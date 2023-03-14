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

    public static MovieResponseDTO movieToMovieResponseDTO(Movie movie){
        MovieResponseDTO movieResponseDTO = MovieResponseDTO.builder()
                .movieLanguage(movie.getMovieLanguage())
                .movieGenre(movie.getMovieGenre())
                .name(movie.getName())
                .duration(movie.getDuration())
                .rating(movie.getRating())
                .build();
        return movieResponseDTO;
    }
}
