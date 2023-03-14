package com.AccioIntern.BookMyShow.Models;

import com.AccioIntern.BookMyShow.Enums.SeatType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "show_Seats")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShowSeat { // this entity represents the virtual seat.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private boolean isBooked;
    private LocalDate bookedAt;
    private int seatPrice;
    private String seatNo;
    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;
    @ManyToOne
    @JoinColumn
    private Show shows;

}
