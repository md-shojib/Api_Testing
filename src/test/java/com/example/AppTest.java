package com.example;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class AppTest 
{
    @Test
    void testGetPosts(){
        Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts/1");
        System.out.println("Status String: "+response.asString());
        System.out.println("Status Code: "+response.getStatusCode());
    }

    @Test
    public void testPostPosts() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts";

        String requestBody = "{ \"title\": \"foo\", \"body\": \"bar\", \"userId\": \"1\" }";

        Response response = given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post()
                .then()
                .statusCode(201)
                .extract().response();

        System.out.println("Response Body: " + response.asPrettyString());
    }
    @Test
    void testDeletePosts(){
        Response response = RestAssured.delete("https://jsonplaceholder.typicode.com/posts/2");
        System.out.println("Status String: "+response.asString());
        System.out.println("Status Code: "+response.getStatusCode());

    }
    @Test
    public void testUpdatePosts() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        String requestBody = "{ \"title\": \"foo\", \"body\": \"bar\", \"userId\": \"1\" }";

        Response response = given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .put("/posts/1")
                .then()
                .statusCode(200)
                .extract().response();

        System.out.println("Response Body: " + response.asPrettyString());
    }
}
