package com.demowebshop.api.model.Request.RegisterUser;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegisterDeviceRequestDto {

    private String platform;

    @JsonProperty("device_id")
    private String deviceId;

    @JsonProperty("device_model")
    private String deviceModel;

    @JsonProperty("os_version")
    private String osVersion;

    @JsonProperty("browser_name")
    private String browserName;

    @JsonProperty("browser_version")
    private String browserVersion;

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getBrowserVersion() {
        return browserVersion;
    }

    public void setBrowserVersion(String browserVersion) {
        this.browserVersion = browserVersion;
    }

    public String getBrowserName() {
        return browserName;
    }

    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    @JsonProperty("user_agent")
    private String userAgent;






}
