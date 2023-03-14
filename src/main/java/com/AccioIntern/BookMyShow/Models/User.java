package com.AccioIntern.BookMyShow.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int age;
    @NonNull
    private String name;
    @Column(unique = true, nullable = false)
    @NonNull
    private String email;
    @Column(unique = true)
    @NonNull
    private String mobNum;
    @NonNull
    private String address;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Ticket> tickets = new ArrayList<>();
}
