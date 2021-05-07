package restAPI.getUsersTests;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import restAPI.models.getUsersModels.getUserDetailsModel.GetUserDetailsResponse;
import restAPI.service.getUsers_Service.GetUsersService;

import static restAPI.conditions.Conditions.statusCode;
import static restAPI.properties.TokenProperty.TOKEN;

public class ParametersExample {
    private GetUsersService getUsersService = new GetUsersService();

    @Test
    @Parameters(value = "userID")
    public void getUser(@Optional("1598") int userID){
        GetUserDetailsResponse response = getUsersService
                .getUserDetails(TOKEN, userID)
                .shouldHave(statusCode(200))
                .responseAs(GetUserDetailsResponse.class);

        int id = response.getData().getId();
        Assert.assertEquals(id, userID);
    }
}
