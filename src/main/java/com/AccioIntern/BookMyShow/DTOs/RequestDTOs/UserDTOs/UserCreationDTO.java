package com.AccioIntern.BookMyShow.DTOs.RequestDTOs.UserDTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCreationDTO {
    @NotBlank(message = "Name shoud not be blank")
    private String name;
    private int age;
    private String address;
    @Pattern(regexp = "^\\d{10}$", message = "enter a valid phone Number")
    @NotBlank(message = "Mobile number should be given")
    private String mobNum;
    @NotBlank(message = "Email address should be given")
    @Email(message = "Enter a valid email address")
    private String email;
}
