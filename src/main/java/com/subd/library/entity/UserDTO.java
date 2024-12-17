package com.subd.library.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDTO {
    private String email;
    private LocalDate registrationDate;
}
