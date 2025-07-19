package com.phonebook.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder

public class AllContactsDto {
    private List<ContactDto> contacts;

}
