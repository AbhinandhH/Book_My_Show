package com.AccioIntern.BookMyShow.Repositories;

import com.AccioIntern.BookMyShow.Models.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreSeatRepository extends JpaRepository<Theatre, Integer> {
}
