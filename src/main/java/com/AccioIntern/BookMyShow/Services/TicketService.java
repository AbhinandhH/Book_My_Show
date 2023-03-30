package com.AccioIntern.BookMyShow.Services;

import com.AccioIntern.BookMyShow.Convertors.TicketConvertors;
import com.AccioIntern.BookMyShow.DTOs.RequestDTOs.TicketDTOs.CancelTicketDTO;
import com.AccioIntern.BookMyShow.DTOs.RequestDTOs.TicketDTOs.TicketBookingDTO;
import com.AccioIntern.BookMyShow.Models.Show;
import com.AccioIntern.BookMyShow.Models.ShowSeat;
import com.AccioIntern.BookMyShow.Models.Ticket;
import com.AccioIntern.BookMyShow.Models.User;
import com.AccioIntern.BookMyShow.Repositories.*;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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
    @Autowired
    JavaMailSender javaMailSender;

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

        String email = user.getEmail();

        sendMail(email, show, bookedSeats);



        return "The ticket has been booked successfully";
    }


    public String cancelTicket(CancelTicketDTO cancelTicketDTO) throws Exception{
        User user;
        try{
            user  = userRepository.findById(cancelTicketDTO.getUserId()).get();
        }catch (Exception e){
            throw new Exception("User not found");
        }

        Show show;
        try{
            show  = showRepository.findById(cancelTicketDTO.getShowId()).get();
        }catch (Exception e){
            throw new Exception("Show not found");
        }

        List<Ticket> tickets = user.getTickets();
        if(tickets.size() == 0){
            throw new Exception("This user hasn't booked tickets");
        }

        Ticket ticket = null;

        for(Ticket ticketOneByOne : tickets){
            if(ticketOneByOne.getShows().equals(show)){
                ticket = ticketOneByOne;
                break;
            }
        }

        if(ticket.equals(null)){
            throw new Exception("This ticket doesn't belongs to the user");
        }

        List<String> seatsBooked = List.of(ticket.getBookedSeats().split(","));

        List<ShowSeat> totalSeatsInThisShow = show.getSeats();

        for(String seatNo : seatsBooked){
            for(ShowSeat showSeat : totalSeatsInThisShow){
                if(showSeat.getSeatNo().equals(seatNo)){
                    showSeat.setBooked(false);
                }
            }
        }

        ticketRepository.delete(ticket);

        show.getTickets().remove(ticket);

        showRepository.save(show);

        user.getTickets().remove(ticket);

        userRepository.save(user);

        return "Ticket canceled successfully";
    }

    private void sendMail(String email, Show show, String bookedSeats) throws MessagingException {

        String filmName = show.getMovie().getName();

        String mailText = "Hi This is to confirm your ticket booking for film '" + filmName + "'\n"
                           + "Booked seats : " + bookedSeats + "\n"
                           + "Thank you. Visit again !!!";

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setFrom("abhinandhabhi53@gmail.com");

        mimeMessageHelper.setTo(email);

        mimeMessageHelper.setText(mailText);

        mimeMessageHelper.setSubject("Confirming your booked ticket");

        javaMailSender.send(mimeMessage);
    }


}
