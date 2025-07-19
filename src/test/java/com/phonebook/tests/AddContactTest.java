package com.phonebook.tests;

import com.phonebook.cor.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.phonebook.apiData.ObjectsData.auth;
import static com.phonebook.apiData.ObjectsData.contact;
import static com.phonebook.apiMethods.AuthApi.login;
import static com.phonebook.apiMethods.ContactApi.addContact;
import static org.hamcrest.Matchers.containsString;

public class AddContactTest extends TestBase {

    String accessToken;

    @BeforeMethod
    public void precondition() {
        String responseToken = login(auth)
                .extract().path("token");

        accessToken = responseToken;
    }

    @Test
    public void addContactSuccessTest() {
        addContact(contact, AUTHORIZATION, accessToken)
                .assertThat().statusCode(200)
                .assertThat().body("message", containsString("Contact was added!"));
    }
}
