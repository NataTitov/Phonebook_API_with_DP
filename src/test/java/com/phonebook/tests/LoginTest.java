package com.phonebook.tests;

import com.phonebook.cor.TestBase;
import com.phonebook.dto.AuthResponseDto;
import com.phonebook.dto.ErrorDto;
import org.testng.annotations.Test;

import static com.phonebook.apiData.ObjectsData.auth;
import static com.phonebook.apiData.ObjectsData.wrongEmail;
import static com.phonebook.apiMethods.AuthApi.login;

public class LoginTest extends TestBase {

    @Test
    public void loginSuccessTest() {
        AuthResponseDto dto = login(auth)
                .assertThat().statusCode(200)
                .extract().response().as(AuthResponseDto.class);

        System.out.println(dto.getToken());
    }

    @Test
    public void loginSuccessTest2() {
        String responseToken = login(auth)
                .assertThat().statusCode(200)
                .extract().path("token");

        System.out.println(responseToken);
    }

    @Test
    public void loginWrongEmailNegativeTest() {
        ErrorDto errorDto = login(wrongEmail)
                .assertThat().statusCode(401)
                .extract().response().as(ErrorDto.class);

        softly.assertEquals(errorDto.getMessage(), "Login or Password incorrect");
        softly.assertEquals(errorDto.getError(), "Unauthorized");
        softly.assertAll();
    }
}
