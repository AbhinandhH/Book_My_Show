package com.AccioIntern.BookMyShow.Controllers;

import com.AccioIntern.BookMyShow.DTOs.RequestDTOs.TheatreDTOs.TheatreCreationDTO;
import com.AccioIntern.BookMyShow.Models.Theatre;
import com.AccioIntern.BookMyShow.Services.TheatreService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theatre")
public class TheatreController {
    @Autowired
    TheatreService theatreService;
    @PostMapping("/add")
    public ResponseEntity<String> createTheatre(@RequestBody @Valid TheatreCreationDTO theatreCreationDTO){
        try{
            return new ResponseEntity<>(theatreService.createTheatre(theatreCreationDTO), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Give required Details about the theatre", HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/get-theatre-showing-particular-movie/{movieId}")
    public ResponseEntity<String> theatresShowingParticularMovie(@PathVariable("movieId") int movieId){
        try{
            return new ResponseEntity<>(theatreService.theatresShowingParticularMovie(movieId), HttpStatus.FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/get-unique-locations")
    public ResponseEntity<String> uniqueLocations(){
        try{
            return new ResponseEntity<>(theatreService.uniqueLocations(), HttpStatus.FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
