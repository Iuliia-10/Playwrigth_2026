package com.demowebshop.tests.api;

import com.demowebshop.api.business.ActivatePromocodeFacade;
import com.demowebshop.api.model.request.activatepromocode.ActivatePromocodeRequestDto;
import com.demowebshop.api.model.response.activatePromocodeResponseDto;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActivatePromocodeApiTest {

    @BeforeMethod
    public void setUp() {

        new RegisterPlayerApiTest().testRegisterPlayer();
    }

    @Test
    public void apiTestActivatePromocode() {

        ActivatePromocodeRequestDto userRequest = new ActivatePromocodeRequestDto();
        userRequest.setCode("1DE6AE8D");

        ActivatePromocodeFacade activatePromocodeFacad = new ActivatePromocodeFacade();

        activatePromocodeResponseDto userResponse = activatePromocodeFacad.activatePromocode(userRequest);

       Assert.assertTrue(userResponse.getStatus());
       Assert.assertTrue(userResponse.getIncludesDepositPromotions());
        Assert.assertFalse(userResponse.getPromotions().isEmpty());
        Assert.assertNotNull(userResponse.getPromotions().getFirst().getId());
        Assert.assertNotNull(userResponse.getPromotions().getFirst().getType());
        Assert.assertNotNull(userResponse.getPromotions().getFirst().getActivationType());
    }
}
