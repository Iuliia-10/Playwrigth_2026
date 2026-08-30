package com.demowebshop.api.business;

import com.demowebshop.api.model.UserRequestDto;
import com.demowebshop.api.model.UserResponseDto;
import com.demowebshop.api.service.AuthService;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;


public class AuthFacad {

    public UserResponseDto loginUser(UserRequestDto userRequest){
        return new AuthService().postLogin(userRequest)
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .as(UserResponseDto.class);
    }
}
