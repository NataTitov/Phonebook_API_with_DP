package com.phonebook.tests;

import com.phonebook.cor.TestBase;
import com.phonebook.dto.AllContactsDto;
import com.phonebook.dto.ContactDto;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.phonebook.apiData.ObjectsData.auth;
import static com.phonebook.apiMethods.AuthApi.getContacts;
import static com.phonebook.apiMethods.AuthApi.login;

public class GetContactsTest extends TestBase {
    String accessToken;

    @BeforeMethod
    public void precondition() {
        String responseToken = login(auth)
                .extract().path("token");

        accessToken = responseToken;
    }

    @Test
    public void getContactsSuccessTest() {
        AllContactsDto contactsDto = getContacts(AUTHORIZATION, accessToken)
                .assertThat().statusCode(200)
                .extract().body().as(AllContactsDto.class);

        for (ContactDto contact : contactsDto.getContacts()) {
            System.out.println(contact.getId() + "***" + contact.getName());
            System.out.println("=================");
        }
    }
}
