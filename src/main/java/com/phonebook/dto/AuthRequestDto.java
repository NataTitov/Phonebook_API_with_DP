package com.phonebook.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder

public class AuthRequestDto {

    private String username;
    private String password;
}
