package com.AccioIntern.BookMyShow.Services;

import com.AccioIntern.BookMyShow.Convertors.UserConvertors;
import com.AccioIntern.BookMyShow.DTOs.RequestDTOs.UserDTOs.UserCreationDTO;
import com.AccioIntern.BookMyShow.Models.User;
import com.AccioIntern.BookMyShow.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public String createUser(UserCreationDTO userCreationDTO) throws Exception{
        User user = UserConvertors.userCreationDTOToUser(userCreationDTO);

        userRepository.save(user);

        return "User created successfully";
    }
}
