package restAPI.service;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static restAPI.properties.TokenProperty.TOKEN;
import static restAPI.properties.UrlLinks.MAIN_URL;

public class RestApiSetupService {

    public RequestSpecification baseSetupHeaders(String token) {
        return RestAssured.given()
                .baseUri(MAIN_URL)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .filters(new RequestLoggingFilter(),
                        new ResponseLoggingFilter(),
                        new AllureRestAssured());
    }

//    @Step
//    public RequestSpecification setXApiKeyToken(String... apiKey){
//        if(apiKey.length == 0){
//            return baseSetupHeaders()
//                    .header("x-api-key", TOKEN);
//        } else
//            return baseSetupHeaders()
//            .header("x-api-key", apiKey[0]);
//    }
}
