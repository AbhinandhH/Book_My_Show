package com.AccioIntern.BookMyShow.Convertors;

import com.AccioIntern.BookMyShow.DTOs.RequestDTOs.UserDTOs.UserCreationDTO;
import com.AccioIntern.BookMyShow.Models.User;

public class UserConvertors {
    public static User userCreationDTOToUser(UserCreationDTO userCreationDTO){
        User user = User.builder()
                .age(userCreationDTO.getAge())
                .name(userCreationDTO.getName())
                .email(userCreationDTO.getEmail())
                .address(userCreationDTO.getAddress())
                .mobNum(userCreationDTO.getMobNum())
                .build();
        return user;
    }
}
