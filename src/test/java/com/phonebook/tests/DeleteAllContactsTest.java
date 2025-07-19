package com.phonebook.tests;

import com.phonebook.cor.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.phonebook.apiData.ObjectsData.auth;
import static com.phonebook.apiMethods.AuthApi.login;
import static com.phonebook.apiMethods.ContactApi.deleteAllContacts;
import static org.hamcrest.Matchers.equalTo;

public class DeleteAllContactsTest extends TestBase {
    String accessToken;

    @BeforeMethod
    public void precondition() {
        String responseToken = login(auth)
                .extract().path("token");

        accessToken = responseToken;
    }

    @Test
    public void deleteAllContactsSuccessTest() {
       deleteAllContacts(AUTHORIZATION, accessToken)
                .assertThat().statusCode(200)
                .assertThat().body("message", equalTo("All contacts was deleted!"));
    }


}
