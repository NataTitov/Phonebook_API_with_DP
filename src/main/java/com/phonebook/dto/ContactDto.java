package com.phonebook.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder

public class ContactDto {

   private String id;
   private String name;
   private String lastName;
   private String email;
   private String phone;
   private String address;
   private String description;
}
