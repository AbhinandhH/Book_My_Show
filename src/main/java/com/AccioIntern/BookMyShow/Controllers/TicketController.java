package com.AccioIntern.BookMyShow.Controllers;

import com.AccioIntern.BookMyShow.DTOs.RequestDTOs.TicketDTOs.TicketBookingDTO;
import com.AccioIntern.BookMyShow.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class TicketController {


    @Autowired
    TicketService ticketService;
    @PostMapping("/book-ticket")
    public ResponseEntity<String> bookTicket(@RequestBody TicketBookingDTO ticketBookingDTO){
        try{
            return new ResponseEntity<>(ticketService.bookTicket(ticketBookingDTO),HttpStatus.CREATED);
        }catch (NoSuchFieldException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}