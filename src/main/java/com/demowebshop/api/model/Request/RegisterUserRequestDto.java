package com.demowebshop.api.model.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Random;

public class RegisterUserRequestDto {

    private int randomDigits = 1000 + new Random().nextInt(9000);
    private String email = "iuliia1007+" + randomDigits + "@sharkscode.com";
    private String password;
    private String type;

    @JsonProperty("is_accept")
    private int isAccept;

    private RegisterDeviceRequestDto device = new RegisterDeviceRequestDto();

    private String language;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public RegisterDeviceRequestDto getDevice() {
        return device;
    }

    public void setDevice(RegisterDeviceRequestDto device) {
        this.device = device;
    }

    public int getIsAccept() {
        return isAccept;
    }

    public void setIsAccept(int isAccept) {
        this.isAccept = isAccept;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}


