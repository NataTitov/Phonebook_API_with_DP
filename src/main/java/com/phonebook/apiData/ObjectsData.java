package com.phonebook.apiData;

import com.phonebook.dto.AuthRequestDto;
import com.phonebook.dto.ContactDto;

public class ObjectsData {

   public static AuthRequestDto auth = AuthRequestDto.builder()
            .username("1a@1b.com")
            .password("Aa12345$")
            .build();

   public static AuthRequestDto wrongEmail = AuthRequestDto.builder()
           .username("1a1b.com")
                        .password("Aa12345$")
                        .build();

    public static ContactDto contact = ContactDto.builder()
            .name("Thomas")
            .lastName("Titov")
            .email("email@gm.com")
            .phone("1234567890")
            .address("Berlin")
            .description("description")
            .build();
}
