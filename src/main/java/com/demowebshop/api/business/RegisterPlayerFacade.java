package com.demowebshop.api.business;

import com.demowebshop.api.model.request.RegisterUser.RegisterUserRequestDto;
import com.demowebshop.api.model.response.RegisterUserResponceDto;
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
