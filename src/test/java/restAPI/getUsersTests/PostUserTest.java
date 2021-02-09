package restAPI.getUsersTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import restAPI.excelUtils.ExcelDataProvider;
import restAPI.models.postUsersModels.postCreateNewUserRequestModel.PostCreateNewUserRequestModel;
import restAPI.models.postUsersModels.postCreateNewUserResponseModel.PostCreateNewUserResponseModel;
import restAPI.service.postUser_Service.PostUserService;

import static org.hamcrest.Matchers.equalTo;
import static restAPI.conditions.Conditions.bodyField;
import static restAPI.conditions.Conditions.statusCode;
import static restAPI.properties.TokenProperty.TOKEN;

public class PostUserTest {

    private PostUserService postUserService = new PostUserService();
    PostCreateNewUserRequestModel requestModel = new PostCreateNewUserRequestModel().randomize();

    @Test(description = "POST Create new user test")
    public void postCreateNewUserTest(){
        PostCreateNewUserResponseModel responseModel = postUserService
                .postCreateNewUser(TOKEN, requestModel)
                .shouldHave(statusCode(200))
                .responseAs(PostCreateNewUserResponseModel.class);

        int code = responseModel.getCode();

        Assert.assertEquals(code, 201);
        Assert.assertEquals(responseModel.getData().getGender(), "Male");
        Assert.assertEquals(responseModel.getData().getStatus(), "Active");
        Assert.assertEquals(responseModel.getData().getName(), requestModel.getName());
        Assert.assertEquals(responseModel.getData().getEmail(), requestModel.getEmail());
    }

    @Test(description = "POST create new user with existing email")
    public void postCreateNewUserWithExistingEmail(){
        postUserService
                .postCreateNewUser(TOKEN, requestModel)
                .shouldHave(statusCode(200),
                        bodyField("code", equalTo(422)),
                        bodyField("data[0].message", equalTo("has already been taken")));
    }

    @Test(description = "POST create new user with wrong body data",
          dataProvider = "Wrong body data for new user creation",
          dataProviderClass = ExcelDataProvider.class)
    public void postCreateUserWithWrongBodyData(Object name, Object email, Object gender, Object status, String message){
            postUserService
                .postCreateNewUser(TOKEN, new PostCreateNewUserRequestModel()
                                                .setName(name)
                                                .setEmail(email)
                                                .setGender(gender)
                                                .setStatus(status))
                .shouldHave(statusCode(200),
                        bodyField("code", equalTo(422)),
                        bodyField("data[0].message", equalTo(message)));
    }
}
