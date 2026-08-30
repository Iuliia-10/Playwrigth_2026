package com.demowebshop.api.business;

import com.demowebshop.api.model.Login.responce.LoginUserResponseDto;
import com.demowebshop.api.model.Register.request.RegisterUserRequestDto;
import com.demowebshop.api.model.Register.responce.RegisterUserResponceDto;
import com.demowebshop.api.service.RegisterService;

public class RegisterPlayerFacad {

    public RegisterUserResponceDto registerUser(RegisterUserRequestDto userRequest){
        return new RegisterService().postRegister(userRequest)
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .as(RegisterUserResponceDto.class);
    }
}
