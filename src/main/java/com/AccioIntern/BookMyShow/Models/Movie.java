package com.AccioIntern.BookMyShow.Models;

import com.AccioIntern.BookMyShow.Enums.MovieGenre;
import com.AccioIntern.BookMyShow.Enums.MovieLanguage;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "movies")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    private String name;
    private double rating;
    private double duration;
    @Enumerated(value = EnumType.STRING)
    @NonNull
    private MovieLanguage movieLanguage;
    @NonNull
    @Enumerated(value = EnumType.STRING)
    private MovieGenre movieGenre;
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Show> shows = new ArrayList<>();
}
