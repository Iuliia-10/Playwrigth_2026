package com.demowebshop.tests.api;

import com.demowebshop.api.business.AuthFacad;
import com.demowebshop.api.model.DeviceRequestDto;
import com.demowebshop.api.model.UserRequestDto;
import com.demowebshop.api.model.UserResponseDto;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

public class apiTestLogin {

    @Test
    public void apiTest1() {

        DeviceRequestDto device = new DeviceRequestDto();
        device.setPlatform("WEB");
        device.setDeviceId("1340e03289fcd79c8e74186c8ade595d");
        device.setDeviceModel("macOS");
        device.setOsVersion("10.15.7");
        device.setAppVersion("6.0.43");
        device.setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/137.0.0.0 Safari/537.36");
        device.setBrowserName("Chrome");
        device.setBrowserVersion("150.0.0.0");

        UserRequestDto userRequest = new UserRequestDto();
        userRequest.setPassword("123456");
        userRequest.setType("email");
        userRequest.setEmail("iuliia1007+1057@sharkscode.com");
        userRequest.setDevice(device);

        AuthFacad authFacad = new AuthFacad();

        UserResponseDto user = authFacad.loginUser(userRequest);

        Assert.assertNotNull(user.getUser());
        Assert.assertTrue(user.getStatus());
        Assert.assertFalse(user.getShowPromoPopup());
        Assert.assertNotNull(user.getUser().getToken());
        Assert.assertNotNull(user.getUser().getId());

        System.out.println("TOOOKEN");
        System.out.println(user.getUser().getToken());
    }
}