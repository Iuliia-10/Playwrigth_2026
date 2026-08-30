package com.demowebshop.api.business;

import com.demowebshop.api.model.ActivatePromocode.ActivatePromocodeRequestDto;
import com.demowebshop.api.model.ActivatePromocode.ActivatePromocodeResponseDto;
import com.demowebshop.api.model.Login.responce.LoginUserResponseDto;
import com.demowebshop.api.service.PromocodeActivateService;

public class ActivatePromocodeFacad {

    public ActivatePromocodeRequestDto activatePromocode(ActivatePromocodeRequestDto userRequest){
        return new PromocodeActivateService().postActivatePromocode(userRequest)
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .as(ActivatePromocodeResponseDto.class);
    }
}
