package com.demowebshop.api.business;

import com.demowebshop.api.model.Request.LoginUser.LoginUserRequestDto;
import com.demowebshop.api.model.Response.LoginUserResponseDto;
import com.demowebshop.api.service.AuthService;


public class LoginPlayerFacade {

    public LoginUserResponseDto loginUser(LoginUserRequestDto userRequest){
        return new AuthService().postLogin(userRequest)
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .as(LoginUserResponseDto.class);
    }
}
