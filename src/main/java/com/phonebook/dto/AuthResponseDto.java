package com.phonebook.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder

public class AuthResponseDto {

    private String token;
}
