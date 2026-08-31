package com.demowebshop.api.service;

import com.demowebshop.api.model.Request.ActivatePromocodeRequestDto;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PromocodeActivateService {

    public Response postActivatePromocode(ActivatePromocodeRequestDto userRequest, String userToken){
        return RestAssured.given()
                .baseUri("https://stage.slotcity.ua")
                .header("Authorization", "Bearer " + userToken)
                .body(userRequest)
                .contentType(ContentType.JSON)
                .log().all()
                .post("apiv2/promocodes/activate");
    }
}
