package com.phonebook.apiMethods;

import com.phonebook.dto.ContactDto;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static groovyjarjarantlr4.v4.tool.AttributeDict.DictType.TOKEN;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpHeaders.AUTHORIZATION;

public class ContactApi {

    public static ValidatableResponse addContact(ContactDto ContactData, String auth, String token) {
        return given()
                .header(auth, token)
                .contentType(ContentType.JSON)
                .body(ContactData)
                .when() // can man nicht schreiben
                .post("contacts")
                .then();
    }
    public static ValidatableResponse deleteContactRequest(String id, String auth, String token) {
        return given()
                .header(auth, token)
                .when()
                .delete("contacts/" + id)
                .then();
    }

    public static ValidatableResponse deleteAllContacts(String auth, String token) {
        return given()
                .header(auth, token)
                .when()
                .delete("contacts/clear")
                .then();
    }
}
