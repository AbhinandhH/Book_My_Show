package com.AccioIntern.BookMyShow.Models;

import com.AccioIntern.BookMyShow.Enums.ShowTypes;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;




@Entity
@Table(name = "shows")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate showDate;
    private LocalTime showTime;
    @Enumerated(value = EnumType.STRING)
    private ShowTypes showType;
    private int showPrice;
    private LocalDate createdOn;
    private LocalDate updatedOn;

    @ManyToOne
    @JoinColumn
    private Movie movie;
    @ManyToOne
    @JoinColumn
    private Theatre theatre;
    @OneToMany(mappedBy = "shows",cascade = CascadeType.ALL)
    private List<ShowSeat> seats = new ArrayList<>();
    @OneToMany(mappedBy = "shows",cascade = CascadeType.ALL)
    List<Ticket> tickets = new ArrayList<>();
}
