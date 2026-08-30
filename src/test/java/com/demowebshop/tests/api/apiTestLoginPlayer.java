package com.demowebshop.tests.api;

import com.demowebshop.api.business.LoginPlayerFacad;
import com.demowebshop.api.model.Login.request.LoginDeviceRequestDto;
import com.demowebshop.api.model.Login.request.LoginUserRequestDto;
import com.demowebshop.api.model.Login.responce.LoginUserResponseDto;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class apiTestLoginPlayer {

    @Test
    public void apiTestLogin(ITestContext context) {

        String email = (String) context.getAttribute("userEmail");
        String password = (String) context.getAttribute("userPassword");

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

        LoginPlayerFacad authFacad = new LoginPlayerFacad();

        LoginUserResponseDto user = authFacad.loginUser(userRequest);

        Assert.assertNotNull(user.getUser());
        Assert.assertTrue(user.getStatus());
        Assert.assertFalse(user.getShowPromoPopup());
        Assert.assertNotNull(user.getUser().getToken());
        Assert.assertNotNull(user.getUser().getId());

        String userToken = user.getUser().getToken();
        context.setAttribute("authToken", userToken);

        System.out.println("LOGGED IN EMAIL: " + email);
        System.out.println("TOKEN: " + user.getUser().getToken());
    }
}