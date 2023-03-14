package com.AccioIntern.BookMyShow.Services;

import com.AccioIntern.BookMyShow.Convertors.TicketConvertors;
import com.AccioIntern.BookMyShow.DTOs.RequestDTOs.TicketDTOs.TicketBookingDTO;
import com.AccioIntern.BookMyShow.Models.Show;
import com.AccioIntern.BookMyShow.Models.ShowSeat;
import com.AccioIntern.BookMyShow.Models.Ticket;
import com.AccioIntern.BookMyShow.Models.User;
import com.AccioIntern.BookMyShow.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TicketService {
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    TheatreRepository theatreRepository;
    @Autowired
    TheatreSeatRepository theatreSeatRepository;
    @Autowired
    ShowRepository showRepository;
    @Autowired
    ShowSeatRepository showSeatRepository;
    @Autowired
    UserRepository userRepository;

    public String bookTicket(TicketBookingDTO ticketBookingDTO) throws Exception{
        Show show;
        try{
            show  = showRepository.findById(ticketBookingDTO.getShowId()).get();
        }catch (NoSuchElementException e){
            throw new NoSuchElementException("Show is not found");
        }

        User user;
        try{
            user = userRepository.findById(ticketBookingDTO.getUserId()).get();
        }catch (Exception e){
            throw new Exception("User is not found");
        }

        List<String> requiredSeats = ticketBookingDTO.getRequiredSeats();
        if(requiredSeats.size() == 0){
            throw new Exception("Select at least one seat");
        }

        List<ShowSeat> totalSeats = show.getSeats();

        List<ShowSeat> seatsTryingToBook = new ArrayList<>();

        for(ShowSeat seat : totalSeats){
            String seatNo = seat.getSeatNo();
            if(requiredSeats.contains(seatNo)){
                if(seat.isBooked()){
                    throw new Exception("The required seats are not available");
                }
                System.out.print(seat.getSeatNo() + " ");
                seatsTryingToBook.add(seat);
            }
        }

        String bookedSeats = "";

        int totalAmount = 0;

        for(ShowSeat seat : seatsTryingToBook){
            seat.setBookedAt(LocalDate.now());
            seat.setBooked(true);
            totalAmount = totalAmount + seat.getSeatPrice() + show.getShowPrice();
            bookedSeats = bookedSeats + seat.getSeatNo() + ",";
        }

        Ticket ticket = TicketConvertors.ticketBuilder(show, totalAmount, bookedSeats, user);

        ticketRepository.save(ticket);

        user.getTickets().add(ticket);

        userRepository.save(user);

        show.getTickets().add(ticket);

        showRepository.save(show);

        return "The ticket has been booked successfully";
    }


}
