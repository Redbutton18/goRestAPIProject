package restAPI.getUsersTests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import restAPI.service.getUsers_Service.GetUsersService;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static restAPI.conditions.Conditions.bodyField;
import static restAPI.conditions.Conditions.statusCode;
import static restAPI.properties.TokenProperty.TOKEN;

public class DataProviderExample {
    private GetUsersService getUsersService = new GetUsersService();

    @Test(description = "Get single user details with wrong user Id",
            dataProvider = "WrongUserIDs")
    public void getUserDetailsWithWrongUserId(Object wrongId) {
        getUsersService
                .getUserDetails(TOKEN, wrongId)
                .shouldHave(statusCode(404),
                        bodyField("meta", equalTo(null)),
                        bodyField("data.message", containsString("Resource not found")));
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
        data[9] = 1;

        return data;
    }
}
