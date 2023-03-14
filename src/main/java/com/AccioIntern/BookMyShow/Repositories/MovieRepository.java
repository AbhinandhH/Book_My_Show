package com.AccioIntern.BookMyShow.Repositories;

import com.AccioIntern.BookMyShow.Models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
