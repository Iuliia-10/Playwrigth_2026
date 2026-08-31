package com.demowebshop.api.model.Response;

public class LoginUserResponseDto {

    private Boolean status;
    private Boolean showPromoPopup;
    private UserData user;

    public LoginUserResponseDto() {
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getShowPromoPopup() {
        return showPromoPopup;
    }

    public void setShowPromoPopup(Boolean showPromoPopup) {
        this.showPromoPopup = showPromoPopup;
    }

    public UserData getUser() {
        return user;
    }

    public void setUser(UserData user) {
        this.user = user;
    }

    public static class UserData {

        private Integer id;
        private String token;

        public UserData() {
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
