package ru.geekbrains.lesson7SpringData.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class AuthRequest {
    private String username;
    private String password;
}
