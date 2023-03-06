package com.bridgelabz.jsonserver;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class JsonServer {
    @Test
    public void fetchAllDataFromJsonServer_Post(){
        given()
                .get("http://localhost:3000/posts")
                .then().log().all().statusCode(200);
    }
    @Test
    public void createPost_Post(){
        given()
                .accept("application/json")
                .contentType("application/json")
                .body("{\n" +
                "        \"id\": 5,\n" +
                "        \"title\": \"empty\",\n" +
                "        \"author\": \"babai\"\n" +
                "    }")
                .when()
                .post("http://localhost:3000/posts")
                .then().log().all().statusCode(201);
    }
    @Test
    public void getSpecificPost_Post(){
        given()
                .contentType("application/json")
                .accept("application/json")
                .when()
                .get("http://localhost:3000/posts/2")
                .then().log().all().statusCode(200);

    }
    @Test
    public void deletePost_Post(){
        given()
                .contentType("application/json")
                .accept("application/json")
                .when()
                .delete("http://localhost:3000/posts/2")
                .then().log().all().statusCode(200);
    }


}
