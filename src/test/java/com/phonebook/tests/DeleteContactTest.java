package com.phonebook.tests;

import com.phonebook.cor.TestBase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.phonebook.apiData.ObjectsData.auth;
import static com.phonebook.apiData.ObjectsData.contact;
import static com.phonebook.apiMethods.AuthApi.login;
import static com.phonebook.apiMethods.ContactApi.addContact;
import static com.phonebook.apiMethods.ContactApi.deleteContactRequest;
import static org.hamcrest.Matchers.containsString;

public class DeleteContactTest extends TestBase {

    String contactId;
    String accessToken;

    @BeforeMethod
    public void precondition() {
        String responseToken = login(auth)
                .extract().path("token");

        accessToken = responseToken;

        String message = addContact(contact, AUTHORIZATION, accessToken)
                .assertThat().statusCode(200)
                .extract().path("message");

        String[] split = message.split(": ");
        contactId = split[1];

        //Contact was added! ID: bd140bbd-db7b-4b13-92cd-9dbdb61a3924
        //[Contact was added! ID] = [0]: [bd140bbd-db7b-4b13-92cd-9dbdb61a3924] = [1]
    }

    @Test
    public void deleteContactSuccessTest() {
        deleteContactRequest(contactId, AUTHORIZATION, accessToken)
                .assertThat().statusCode(200)
                .assertThat().body("message", containsString("Contact was deleted!"));

        logger.info("Assert checks status code is 200");
    logger.info("Assert checks message contains - Contact was deleted!");
    }

}
