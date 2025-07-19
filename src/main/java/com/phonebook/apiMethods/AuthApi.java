package com.phonebook.apiMethods;

import com.phonebook.dto.AuthRequestDto;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static groovyjarjarantlr4.v4.tool.AttributeDict.DictType.TOKEN;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpHeaders.AUTHORIZATION;

public class AuthApi {

    public static ValidatableResponse login(AuthRequestDto loginData) {
        return given()
                .contentType(ContentType.JSON)
                .body(loginData)
                .when()
                .post("user/login/usernamepassword")
                .then();
    }

    public static ValidatableResponse getContacts(String auth, String token) {
        return given()
                .header(auth, token)
                .when()
                .get("contacts")
                .then();
    }
}
