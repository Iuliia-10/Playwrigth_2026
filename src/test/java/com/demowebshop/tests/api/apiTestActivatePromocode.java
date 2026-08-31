package com.demowebshop.tests.api;

import com.demowebshop.api.business.ActivatePromocodeFacad;
import com.demowebshop.api.model.ActivatePromocode.ActivatePromocodeRequestDto;
import com.demowebshop.api.model.ActivatePromocode.ActivatePromocodeResponseDto;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class apiTestActivatePromocode {

    @Test
    public void apiTestActivatePromocode(ITestContext context) {

        String token = (String) context.getAttribute("authToken");

        ActivatePromocodeRequestDto userRequest = new ActivatePromocodeRequestDto();
        userRequest.setCode("1DE6AE8D");

        ActivatePromocodeFacad activatePromocodeFacad = new ActivatePromocodeFacad();

        ActivatePromocodeResponseDto userResponse = activatePromocodeFacad.activatePromocode(userRequest, token);

       Assert.assertTrue(userResponse.getStatus());
       Assert.assertTrue(userResponse.getIncludesDepositPromotions());
        Assert.assertFalse(userResponse.getPromotions().isEmpty());
        Assert.assertNotNull(userResponse.getPromotions().get(0).getId());
        Assert.assertNotNull(userResponse.getPromotions().get(0).getType());
        Assert.assertNotNull(userResponse.getPromotions().get(0).getActivationType());



    }
}
