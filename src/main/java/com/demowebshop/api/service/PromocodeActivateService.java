package com.demowebshop.api.service;

import com.demowebshop.api.model.ActivatePromocode.ActivatePromocodeRequestDto;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PromocodeActivateService {

    public Responce postActivatePromocode(ActivatePromocodeRequestDto userRequest){
        return RestAssured.given()
                .baseUri("https://stage.slotcity.ua")
                .body(userRequest)
                .contentType(ContentType.JSON)
                .log().all()
                .post("apiv2/promocodes/activate");
    }
}
