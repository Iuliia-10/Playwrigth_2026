package com.demowebshop.api.business;

import com.demowebshop.api.model.request.activatepromocode.ActivatePromocodeRequestDto;
import com.demowebshop.api.model.response.activatePromocodeResponseDto;
import com.demowebshop.api.service.PromocodeActivateService;
import com.demowebshop.api.utils.SessionContext;

public class ActivatePromocodeFacade {

    public activatePromocodeResponseDto activatePromocode(ActivatePromocodeRequestDto userRequest){
        String userToken = SessionContext.getToken();

        return new PromocodeActivateService().postActivatePromocode(userRequest, userToken)
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .as(activatePromocodeResponseDto.class);
    }
}
