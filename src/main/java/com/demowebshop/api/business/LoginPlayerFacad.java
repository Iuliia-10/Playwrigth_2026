package com.demowebshop.api.business;

import com.demowebshop.api.model.Login.request.LoginUserRequestDto;
import com.demowebshop.api.model.Login.responce.LoginUserResponseDto;
import com.demowebshop.api.service.AuthService;


public class LoginPlayerFacad {

    public LoginUserResponseDto loginUser(LoginUserRequestDto userRequest){
        return new AuthService().postLogin(userRequest)
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .as(LoginUserResponseDto.class);
    }
}
