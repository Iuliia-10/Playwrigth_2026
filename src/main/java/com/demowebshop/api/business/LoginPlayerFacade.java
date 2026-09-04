package com.demowebshop.api.business;

import com.demowebshop.api.model.request.loginuser.LoginUserRequestDto;
import com.demowebshop.api.model.response.LoginUserResponseDto;
import com.demowebshop.api.service.LoginService;


public class LoginPlayerFacade {

    public LoginUserResponseDto loginUser(LoginUserRequestDto userRequest){
        return new LoginService().postLogin(userRequest)
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .as(LoginUserResponseDto.class);
    }
}
