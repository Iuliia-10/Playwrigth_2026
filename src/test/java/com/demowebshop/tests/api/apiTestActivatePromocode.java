package com.demowebshop.tests.api;

import com.demowebshop.api.business.ActivatePromocodeFacad;
import com.demowebshop.api.model.ActivatePromocode.ActivatePromocodeRequestDto;
import com.demowebshop.api.model.ActivatePromocode.ActivatePromocodeResponseDto;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class apiTestActivatePromocode {

    @Test
    public void apiTestLogin(ITestContext context) {

        String token = (String) context.getAttribute("token");

        ActivatePromocodeRequestDto userRequest = new ActivatePromocodeRequestDto();
        userRequest.setCode("1DE6AE8D");

        ActivatePromocodeFacad activatePromocodeFacad = new ActivatePromocodeFacad();

        ActivatePromocodeResponseDto user = ActivatePromocodeFacad.


    }
}
