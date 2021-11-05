package restAPI.service.getUsers_Service;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import restAPI.AssertableResponse;
import restAPI.service.RestApiSetupService;

@Slf4j
public class GetUsersService extends RestApiSetupService {
    @Step("Get list with all users")
    public AssertableResponse getAllUsers(String token){
        log.info("Get all users {}");
        Response register =
                baseSetupHeaders(token)
                .when()
                .get("public/v1/users")
                .then().extract().response();

        return new AssertableResponse(register);
    }

    @Step("Get single user details")
    public AssertableResponse getUserDetails(String token, Object userId){
        log.info("Get single user details {}");
        Response register =
                baseSetupHeaders(token)
                .when()
                .get("public/v1/users/" + userId)
                .then().extract().response();

        return new AssertableResponse(register);
    }
}
