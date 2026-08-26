package com.demowebshop.api.service;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeviceRequestDto {

    private String platform;

    @JsonProperty("device_id")
    private String deviceId;

    @JsonProperty("device_model")
    private String deviceModel;

    @JsonProperty("os_version")
    private String osVersion;

    @JsonProperty("app_version")
    private String appVersion;

    @JsonProperty("user_agent")
    private String userAgent;

    @JsonProperty("browser_name")
    private String browserName;

    @JsonProperty("browser_version")
    private String browserVersion;

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getBrowserName() {
        return browserName;
    }

    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }

    public String getBrowserVersion() {
        return browserVersion;
    }

    public void setBrowserVersion(String browserVersion) {
        this.browserVersion = browserVersion;
    }
}