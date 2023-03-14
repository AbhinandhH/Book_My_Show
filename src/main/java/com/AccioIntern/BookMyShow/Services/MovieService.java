package com.AccioIntern.BookMyShow.Services;

import com.AccioIntern.BookMyShow.Convertors.MovieConvertors;
import com.AccioIntern.BookMyShow.DTOs.RequestDTOs.MovieDTOs.MovieCreationDTO;
import com.AccioIntern.BookMyShow.DTOs.ResponseDTOs.MovieDTOs.MovieResponseDTO;
import com.AccioIntern.BookMyShow.Models.Movie;
import com.AccioIntern.BookMyShow.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    public String createMovie(MovieCreationDTO movieCreationDTO) throws NullPointerException{
        Movie movie = MovieConvertors.movieCreationDtoToMovie(movieCreationDTO);

        movieRepository.save(movie);

        return "Movie added successfully";
    }


    public String getMovieWithMaximumNoOfShows() throws Exception{
        List<Movie> movieList = movieRepository.findAll();
        if(movieList.size() == 0){
            throw new Exception("There is no movies added yet");
        }
        int max = 0;
        Movie maximumShowMovie = null;
        for(Movie movie : movieList){
            if(movie.getShows().size() > max){
                max = movie.getShows().size();
                maximumShowMovie = movie;
            }
        }
        return MovieConvertors.movieToMovieResponseDTO(maximumShowMovie).toString();
    }
}
