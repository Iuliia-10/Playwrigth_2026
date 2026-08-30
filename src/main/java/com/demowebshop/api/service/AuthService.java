package com.demowebshop.api.service;

import com.demowebshop.api.model.UserRequestDto;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AuthService {

    public Response postLogin(UserRequestDto userRequest){
        return RestAssured.given()
                .baseUri("https://stage.beton.ua")
                .body(userRequest)
                .contentType(ContentType.JSON)
                .headers("X-Fingerprint-Hash", "test")
                .log().all()
                .post("/auth/login");
    }
    }


