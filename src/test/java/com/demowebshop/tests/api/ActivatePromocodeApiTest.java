package com.demowebshop.tests.api;

import com.demowebshop.api.business.ActivatePromocodeFacade;
import com.demowebshop.api.model.Request.ActivatePromocodeRequestDto;
import com.demowebshop.api.model.Response.ActivatePromocodeResponseDto;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActivatePromocodeApiTest {

    @BeforeMethod
    public void setUp() {

        new RegisterPlayerApiTest().TestRegisterPlayer();
    }

    @Test
    public void apiTestActivatePromocode() {

        ActivatePromocodeRequestDto userRequest = new ActivatePromocodeRequestDto();
        userRequest.setCode("1DE6AE8D");

        ActivatePromocodeFacade activatePromocodeFacad = new ActivatePromocodeFacade();

        ActivatePromocodeResponseDto userResponse = activatePromocodeFacad.activatePromocode(userRequest);

       Assert.assertTrue(userResponse.getStatus());
       Assert.assertTrue(userResponse.getIncludesDepositPromotions());
        Assert.assertFalse(userResponse.getPromotions().isEmpty());
        Assert.assertNotNull(userResponse.getPromotions().get(0).getId());
        Assert.assertNotNull(userResponse.getPromotions().get(0).getType());
        Assert.assertNotNull(userResponse.getPromotions().get(0).getActivationType());
    }
}
