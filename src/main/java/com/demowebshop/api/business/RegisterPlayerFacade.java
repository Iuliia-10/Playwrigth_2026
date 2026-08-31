package com.demowebshop.api.business;

import com.demowebshop.api.model.Request.RegisterUserRequestDto;
import com.demowebshop.api.model.Response.RegisterUserResponceDto;
import com.demowebshop.api.service.RegisterService;

public class RegisterPlayerFacade {

    public RegisterUserResponceDto registerUser(RegisterUserRequestDto userRequest){
        return new RegisterService().postRegister(userRequest)
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .as(RegisterUserResponceDto.class);
    }
}
