package com.sporty.shoes.dto;

import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserDTO {
    @Email
    private String email;
    private String username;
    private String password;
    private String role;
    private boolean enabled;

}
