package com.demowebshop.api.service;

import com.demowebshop.api.model.Request.RegisterUser.RegisterUserRequestDto;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RegisterService {

    public Response postRegister(RegisterUserRequestDto userRequest){
        return RestAssured.given()
                .baseUri("https://stage.slotcity.ua")
                .body(userRequest)
                .contentType(ContentType.JSON)
                .headers("X-Fingerprint-Hash", "test")
                .log().all()
                .post("auth/v2/register");
    }
}
