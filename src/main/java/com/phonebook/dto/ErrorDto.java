package com.phonebook.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder

public class ErrorDto {

    private String timestamp;
    private int status;
    private String error;
    private Object message;
    private String path;
}
