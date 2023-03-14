package com.AccioIntern.BookMyShow.Convertors;

import com.AccioIntern.BookMyShow.Models.Show;
import com.AccioIntern.BookMyShow.Models.Ticket;
import com.AccioIntern.BookMyShow.Models.User;

public class TicketConvertors {
    public static Ticket ticketBuilder(Show show, int totalAmount, String bookedSeats, User user){
        Ticket ticket = Ticket.builder()
                .showDate(show.getShowDate())
                .movieName(show.getMovie().getName())
                .bookedSeats(bookedSeats)
                .totalAmount(totalAmount)
                .shows(show)
                .user(user)
                .showTiming(show.getShowTime())
                .theaterName(show.getTheatre().getName())
                .build();
        return ticket;
    }
}
