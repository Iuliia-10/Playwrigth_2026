package com.demowebshop.api.model.Login.request;

public class LoginUserRequestDto {

    private String email;
    private String password;
    private String type;
    private LoginDeviceRequestDto device = new LoginDeviceRequestDto();

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LoginDeviceRequestDto getDevice() {
        return device;
    }

    public void setDevice(LoginDeviceRequestDto device) {
        this.device = device;
    }
}
