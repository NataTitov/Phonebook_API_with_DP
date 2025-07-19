package com.phonebook.cor;

import io.restassured.RestAssured;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {

    public static Logger logger = LoggerFactory.getLogger(TestBase.class);

    public static final String AUTHORIZATION = "Authorization";

    public static SoftAssert softly = new SoftAssert();

    @BeforeMethod
    public void init() {
        RestAssured.baseURI = "https://contactapp-telran-backend.herokuapp.com";
        RestAssured.basePath = "v1";
    }

    @BeforeMethod
    public void setUp(Method method, Object[] p){
        logger.info("logger info " + method.getName() + " with data: " + Arrays.asList(p));
    }

    @AfterMethod()
    public void tearDown(ITestResult result){
        if (result.isSuccess()) {
            logger.info("PASSEND: " + result.getMethod().getMethodName());
        }else {
            logger.error("FAILED: " + result.getMethod().getMethodName());
        }
        logger.info("=============================");
    }
}
