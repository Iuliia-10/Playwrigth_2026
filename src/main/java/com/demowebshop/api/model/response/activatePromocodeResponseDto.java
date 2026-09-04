package com.demowebshop.api.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class activatePromocodeResponseDto {

    private Boolean status;
    private Boolean includesDepositPromotions;

    @JsonProperty("promotions")
    private List<PromotionsData> promotions;

    public List<PromotionsData> getPromotions() {
        return promotions;
    }

    public void setPromotions(List<PromotionsData> promotions) {
        this.promotions = promotions;
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

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PromotionsData {

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