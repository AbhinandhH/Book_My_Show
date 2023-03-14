package com.AccioIntern.BookMyShow.DTOs.RequestDTOs.UserDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCreationDTO {
    private String name;
    private int age;
    private String address;
    private String mobNum;
    private String email;
}
