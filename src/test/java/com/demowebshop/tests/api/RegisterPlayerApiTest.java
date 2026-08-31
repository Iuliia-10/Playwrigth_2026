package com.demowebshop.tests.api;

import com.demowebshop.api.business.RegisterPlayerFacade;
import com.demowebshop.api.model.Request.RegisterDeviceRequestDto;
import com.demowebshop.api.model.Request.RegisterUserRequestDto;
import com.demowebshop.api.model.Response.RegisterUserResponceDto;
import com.demowebshop.api.utils.SessionContext;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class RegisterPlayerApiTest {

    public static String playerEmail;
    public static String playerPassword;

    @Test
    public void TestRegisterPlayer(){

        RegisterDeviceRequestDto device = new RegisterDeviceRequestDto();
        device.setPlatform("WEB");
        device.setDeviceId("30560444d8307f36110e979e1b888bf9");
        device.setDeviceModel("Web Mac OS Chrome 150");
        device.setOsVersion("10.15.7");
        device.setBrowserName("Chrome");
        device.setBrowserVersion("150.0.0.0");
        device.setUserAgent("150.0.0.0");

        RegisterUserRequestDto userRequest = new RegisterUserRequestDto();
        userRequest.setPassword("123456");
        userRequest.setType("email");
        userRequest.setIsAccept(1);
        userRequest.setDevice(device);
        userRequest.setLanguage("uk");

        playerEmail = userRequest.getEmail();
        playerPassword = userRequest.getPassword();

        RegisterPlayerFacade registerPlayerFacade = new RegisterPlayerFacade();

        RegisterUserResponceDto userResponse = registerPlayerFacade.registerUser(userRequest);

        Assert.assertNotNull(userResponse.getUser());
        Assert.assertTrue(userResponse.getStatus());
        Assert.assertTrue(userResponse.getShowPromoPopup());
        Assert.assertEquals(userResponse.getFlow(), "register");
        Assert.assertNotNull(userResponse.getUser().getToken());
        Assert.assertNotNull(userResponse.getUser().getId());
        Assert.assertNotNull(userResponse.getUser().getSessionId());
        Assert.assertNotNull(userResponse.getUser().getDeviceId());

        SessionContext.setToken(userResponse.getUser().getToken());

        System.out.println("TOKEN");
        System.out.println(userResponse.getUser().getToken());

    }
}
