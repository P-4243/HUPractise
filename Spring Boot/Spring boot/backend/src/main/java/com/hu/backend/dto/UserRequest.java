package com.hu.backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRequest {
    @NotBlank(message="name is required")
    @Size(min=2,max=50)
    private String name;

    @NotBlank(message = "email is required")
    @Email(message = "invalid email format")
    private String email;
}
