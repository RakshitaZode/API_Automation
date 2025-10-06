package com.demo.api_automation;

import base.APIBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.Map;
import static io.restassured.RestAssured.given;

public class UsersAPI extends APIBase {

    // HTTP METHODS (CRUD)

     public Response getAllPosts()
     {
        return given()
                .spec(request)
                .when()
                .get("/posts")
                .then()
                .log().all().extract().response();
     }

    public Response getPostById(int id)
    {
        return given()
                .spec(request)
                .when()
                .get("/posts/" + id)
                .then()
                .log().all().extract().response();
    }

    //JSON Object is used for sending request body
    public Response createPost(String requestBody)
    {
        return given()
                .spec(request)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/posts")
                .then()
                .log().all().extract().response();
    }

    //Here I have used HashMap
    public Response createPost(Map<String, Object> hm)
    {
        return given()
                .spec(request)
                .contentType(ContentType.JSON)
                .body(hm)
                .when()
                .post("/posts")
                .then()
                .log().all().extract().response();
    }

    public Response updatePost(int id, String requestBody)
    {
        return given()
                .spec(request)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .put("/posts/" + id)
                .then()
                .log().all().extract().response();
    }

    public Response deletePost(int id)
    {
        return given()
                .spec(request)
                .when()
                .delete("/posts/" + id)
                .then()
                .log().all().extract().response();
    }

    // NEGATIVE TCs

    public Response invalidHttpMethod(int id) 
    {
        return given()
                .spec(request)
                .when()
                .patch("/posts/" + id)
                .then()
                .log().all().extract().response();
    }

    public Response createPostWithInvalidContentType(String invalidBody) 
    {
        return given()
                .spec(request)
                .contentType(ContentType.TEXT)
                .body(invalidBody)
                .when()
                .post("/posts")
                .then()
                .log().all() .extract().response();
    }

    public Response createPostWithEmptyBody()
    {
        return given()
                .spec(request)
                .contentType(ContentType.JSON)
                .body("{}")
                .when()
                .post("/posts")
                .then()
                .log().all().extract().response();
    }
}
