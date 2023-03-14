package com.AccioIntern.BookMyShow.Controllers;

import com.AccioIntern.BookMyShow.DTOs.RequestDTOs.ShowDTOs.ShowCreationDTO;
import com.AccioIntern.BookMyShow.Services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/show")
public class ShowController {
    @Autowired
    ShowService showService;
    @PostMapping("/add")
    public ResponseEntity<String> createShow(@RequestBody ShowCreationDTO showCreationDTO){
        try{
            return new ResponseEntity<>(showService.createShow(showCreationDTO), HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/cancel-show/{id}")
    public ResponseEntity<String> cancelShow(@PathVariable("id") Integer showId){
        try{
            return new ResponseEntity<>(showService.cancelShow(showId), HttpStatus.GONE);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
