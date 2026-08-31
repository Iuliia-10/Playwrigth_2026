package com.demowebshop.api.business;

import com.demowebshop.api.model.Request.ActivatePromocode.ActivatePromocodeRequestDto;
import com.demowebshop.api.model.Response.ActivatePromocodeResponseDto;
import com.demowebshop.api.service.PromocodeActivateService;
import com.demowebshop.api.utils.SessionContext;

public class ActivatePromocodeFacade {

    public ActivatePromocodeResponseDto activatePromocode(ActivatePromocodeRequestDto userRequest){
        String userToken = SessionContext.getToken();

        return new PromocodeActivateService().postActivatePromocode(userRequest, userToken)
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .as(ActivatePromocodeResponseDto.class);
    }
}
