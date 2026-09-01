package com.demowebshop.api.service;

import com.demowebshop.api.model.Request.LoginUser.LoginUserRequestDto;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class LoginService {

    public Response postLogin(LoginUserRequestDto userRequest){
        return RestAssured.given()
                .baseUri("https://stage.slotcity.ua")
                .body(userRequest)
                .contentType(ContentType.JSON)
                .headers("X-Fingerprint-Hash", "test")
                .log().all()
                .post("/auth/login");
    }
    }


