package com.AccioIntern.BookMyShow.Repositories;

import com.AccioIntern.BookMyShow.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
