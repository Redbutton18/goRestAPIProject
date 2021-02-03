package restAPI.getUsersTests;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.testng.Assert;
import org.testng.annotations.Test;
import restAPI.models.postUsersModels.postCreateNewUserRequestModel.PostCreateNewUserRequestModel;
import restAPI.models.postUsersModels.postCreateNewUserResponseModel.PostCreateNewUserResponseModel;
import restAPI.service.postUser_Service.PostUserService;

import static restAPI.conditions.Conditions.statusCode;
import static restAPI.properties.TokenProperty.TOKEN;

public class PostUserTest {

    private PostUserService postUserService = new PostUserService();

    @Test(description = "POST Create new user test")
    public void postCreateNewUserTest(){
        PostCreateNewUserRequestModel requestModel = new PostCreateNewUserRequestModel();
        PostCreateNewUserResponseModel responseModel = postUserService
                .postCreateNewUser(TOKEN, requestModel.randomize())
                .shouldHave(statusCode(200))
                .responseAs(PostCreateNewUserResponseModel.class);

        int code = responseModel.getCode();

        Assert.assertEquals(code, 201);
        Assert.assertEquals(responseModel.getData().getGender(), "Male");
        Assert.assertEquals(responseModel.getData().getStatus(), "Active");
        Assert.assertEquals(responseModel.getData().getName(), requestModel.getName());
        Assert.assertEquals(responseModel.getData().getEmail(), requestModel.getEmail());
    }
}
