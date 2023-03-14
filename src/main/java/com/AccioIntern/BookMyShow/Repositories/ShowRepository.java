package com.AccioIntern.BookMyShow.Repositories;

import com.AccioIntern.BookMyShow.Models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Show,Integer> {
}
