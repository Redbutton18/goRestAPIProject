package restAPI.service.postUser_Service;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import restAPI.AssertableResponse;
import restAPI.models.postUsersModels.postCreateNewUserRequestModel.PostCreateNewUserRequestModel;
import restAPI.service.RestApiSetupService;

@Slf4j
public class PostUserService extends RestApiSetupService {
    @Step("Post new user")
    public AssertableResponse postCreateNewUser(String token, PostCreateNewUserRequestModel postRequestModel){
        log.info("Post create new user {}", postRequestModel);
        Response register =
                baseSetupHeaders(token)
                        .body(postRequestModel)
                        .when()
                        .post("public-api/users")
                        .then().extract().response();
        return new AssertableResponse(register);
    }
}
