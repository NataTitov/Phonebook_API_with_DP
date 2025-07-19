package com.phonebook.cor;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class TestBase {


    public static final String AUTHORIZATION = "Authorization";

    public static SoftAssert softly = new SoftAssert();

    @BeforeMethod
    public void init() {
        RestAssured.baseURI = "https://contactapp-telran-backend.herokuapp.com";
        RestAssured.basePath = "v1";
    }
}
