package com.AccioIntern.BookMyShow.Models;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Getter
@Setter
@Table(name = "theatres")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    private String name;
    @NonNull
    private String Location;

    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
    private List<TheatreSeat> theatreSeats = new ArrayList<>();

    @OneToMany(mappedBy = "theatre",cascade = CascadeType.ALL)
    private List<Show> shows = new ArrayList();
}
