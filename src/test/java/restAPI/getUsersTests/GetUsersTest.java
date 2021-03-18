package restAPI.getUsersTests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import restAPI.models.getUsersModels.getAllUsersModel.GetUsersResponseModel;
import restAPI.models.getUsersModels.getUserDetailsModel.GetUserDetailsResponse;
import restAPI.service.getUsers_Service.GetUsersService;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static restAPI.conditions.Conditions.bodyField;
import static restAPI.conditions.Conditions.statusCode;
import static restAPI.properties.TokenProperty.TOKEN;

public class GetUsersTest {

    private GetUsersService getUsersService = new GetUsersService();
    private int userId = 140;

    @Test(description = "Get list with all users")
    public void getAllUsers(){
        GetUsersResponseModel response = getUsersService
                .getAllUsers(TOKEN)
                .shouldHave(statusCode(200))
                .responseAs(GetUsersResponseModel.class);

        int dataLength = response.getData().size();
        int limit = response.getMeta().getPagination().getLimit();

        Assert.assertEquals(dataLength, limit);
    }

    @Test(description = "Get single user details")
    public void getUserDetails() {
        GetUserDetailsResponse response = getUsersService
                .getUserDetails(TOKEN, userId)
                .shouldHave(statusCode(200))
                .responseAs(GetUserDetailsResponse.class);

        int id = response.getData().getId();
        Assert.assertEquals(id, userId);
    }

    @Test(description = "Get single user details with wrong user Id",
          dataProvider = "WrongUserIDs")
    public void getUserDetailsWithWrongUserId(Object wrongId) {

        getUsersService
                .getUserDetails(TOKEN, wrongId)
                .shouldHave(statusCode(200),
                        bodyField("data.message", containsString("Resource not found")),
                        bodyField("code", equalTo(404)));
    }

    @DataProvider(name = "WrongUserIDs")
    public Object[] dataForTest() {
        Object[] data = new Object[10];
        data[0] = -1000000000;
        data[1] = "0";
        data[2] = "asv";
        data[3] = 0;
        data[4] = -1;
        data[5] = -0;
        data[6] = 1000000000;
        data[7] = "!@#$%^&*";
        data[8] = null;

        return data;
    }
}
