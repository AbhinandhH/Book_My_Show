package com.AccioIntern.BookMyShow.Models;

import com.AccioIntern.BookMyShow.Enums.SeatType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "theatreSeats")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TheatreSeat { //this entity represents how the Physical theatre seat behave like.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String seatNo;
    private SeatType seatType;

    @ManyToOne
    @JoinColumn
    private Theatre theatre;
}
