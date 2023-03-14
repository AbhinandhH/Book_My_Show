package com.AccioIntern.BookMyShow.Controllers;

import com.AccioIntern.BookMyShow.DTOs.RequestDTOs.ShowDTOs.ShowCreationDTO;
import com.AccioIntern.BookMyShow.Services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
