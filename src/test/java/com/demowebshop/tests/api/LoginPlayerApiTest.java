package com.demowebshop.tests.api;

import com.demowebshop.api.business.LoginPlayerFacade;
import com.demowebshop.api.model.request.loginuser.LoginDeviceRequestDto;
import com.demowebshop.api.model.request.loginuser.LoginUserRequestDto;
import com.demowebshop.api.model.response.LoginUserResponseDto;
import com.demowebshop.api.utils.SessionContext;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPlayerApiTest {

    @BeforeMethod
    public void setUp() {
        new RegisterPlayerApiTest().testRegisterPlayer();
    }

    @Test
    public void apiTestLogin() {

        String email = RegisterPlayerApiTest.playerEmail;
        String password = RegisterPlayerApiTest.playerPassword;

        LoginDeviceRequestDto device = new LoginDeviceRequestDto();
        device.setPlatform("WEB");
        device.setDeviceId("1340e03289fcd79c8e74186c8ade595d");
        device.setDeviceModel("macOS");
        device.setOsVersion("10.15.7");
        device.setAppVersion("6.0.43");
        device.setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/137.0.0.0 Safari/537.36");
        device.setBrowserName("Chrome");
        device.setBrowserVersion("150.0.0.0");

        LoginUserRequestDto userRequest = new LoginUserRequestDto();
        userRequest.setPassword(password);
        userRequest.setType("email");
        userRequest.setEmail(email);
        userRequest.setDevice(device);

        LoginPlayerFacade authFacad = new LoginPlayerFacade();

        LoginUserResponseDto user = authFacad.loginUser(userRequest);

        Assert.assertNotNull(user.getUser());
        Assert.assertTrue(user.getStatus());
        Assert.assertFalse(user.getShowPromoPopup());
        Assert.assertNotNull(user.getUser().getToken());
        Assert.assertNotNull(user.getUser().getId());

        String userToken = user.getUser().getToken();
        SessionContext.setToken(userToken);

        System.out.println("LOGGED IN EMAIL: " + email);
        System.out.println("TOKEN: " + user.getUser().getToken());
    }
}