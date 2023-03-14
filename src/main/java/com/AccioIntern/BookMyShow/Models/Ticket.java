package com.AccioIntern.BookMyShow.Models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "tickets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int totalAmount;
    private String movieName;
    private String ticketId = UUID.randomUUID().toString();
    private LocalDate showDate;
    private LocalTime showTiming;
    private String theaterName;
    private String bookedSeats;
    @ManyToOne
    @JoinColumn
    private User user;

    @ManyToOne
    @JoinColumn
    private Show shows;

}
