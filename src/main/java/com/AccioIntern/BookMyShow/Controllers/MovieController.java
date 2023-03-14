package com.AccioIntern.BookMyShow.Controllers;

import com.AccioIntern.BookMyShow.DTOs.RequestDTOs.MovieDTOs.MovieCreationDTO;
import com.AccioIntern.BookMyShow.DTOs.ResponseDTOs.MovieDTOs.MovieResponseDTO;
import com.AccioIntern.BookMyShow.Models.Movie;
import com.AccioIntern.BookMyShow.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    MovieService movieService;
    @PostMapping("/add")
    public ResponseEntity<String> createMovie(@RequestBody MovieCreationDTO movieCreationDTO){
        try{
            return new ResponseEntity<>(movieService.createMovie(movieCreationDTO), HttpStatus.CREATED);
        }catch (NullPointerException e){
            return new ResponseEntity<>("Give the required details of movie", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get_movie_having_maximum_shows")
    public ResponseEntity<String> getMovieWithMaximumNoOfShows(){
        try{
            return new ResponseEntity<>(movieService.getMovieWithMaximumNoOfShows(),HttpStatus.FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
