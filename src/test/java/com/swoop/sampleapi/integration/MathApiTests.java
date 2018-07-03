package com.swoop.sampleapi.integration;

import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class MathApiTests {

    @Test
    public void test_MathAdd_GetRequest() {
        given().
            param("n1", 2.2).
            param("n2", 4.3).
        when().
            get("math/add").
        then().
            assertThat().
            statusCode(200).
        and().
            assertThat().
            body("result", is(6.5f));
    }

    @Test
    public void test_MathAdd_GetRequest_MissingParams() {
        given().
        when().
            get("/math/add").
        then().
            assertThat().
            statusCode(400);

    }

    @Test
    public void test_MathAdd_PostRequest() {
        String json = "{\"firstNumber\":2.2,\"secondNumber\":4.3}";
        given().
            header("Content-Type", "application/json").
            body(json).
        when().
            post("/math/add").
        then().
            assertThat().
            statusCode(200).
        and().
            assertThat().
            body("result", is(6.5f));
    }


    @Test
    public void test_MathAdd_PostRequest_MissingParams() {
        given().
            header("Content-Type", "application/json").
        when().
            post("/math/add").
        then().
            assertThat().
            statusCode(400);

    }
}
