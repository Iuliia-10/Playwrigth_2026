package com.demowebshop.api.business;

import com.demowebshop.api.model.ActivatePromocode.ActivatePromocodeRequestDto;
import com.demowebshop.api.model.ActivatePromocode.ActivatePromocodeResponseDto;
import com.demowebshop.api.service.PromocodeActivateService;

public class ActivatePromocodeFacad {

    public ActivatePromocodeResponseDto activatePromocode(ActivatePromocodeRequestDto userRequest, String userToken){
        return new PromocodeActivateService().postActivatePromocode(userRequest, userToken)
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .as(ActivatePromocodeResponseDto.class);
    }
}
