package com.demowebshop.api.model.ActivatePromocode;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ActivatePromocodeResponseDto {

    private Boolean status;
    private Boolean includesDepositPromotions;
    private PromotionsData promotionsData;

    public PromotionsData getPromotionsdata() {
        return promotionsdata;
    }

    public void setPromotionsdata(PromotionsData promotionsdata) {
        this.promotionsdata = promotionsdata;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getIncludesDepositPromotions() {
        return includesDepositPromotions;
    }

    public void setIncludesDepositPromotions(Boolean includesDepositPromotions) {
        this.includesDepositPromotions = includesDepositPromotions;
    }

    public static class PromotionsData{

        private Integer id;
        private String type;
        @JsonProperty("activation_type")
        private String activationType;

        public String getActivationType() {
            return activationType;
        }

        public void setActivationType(String activationType) {
            this.activationType = activationType;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }




    }




}
