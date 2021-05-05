package restAPI.getUsersTests;

import org.testng.Assert;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import restAPI.models.getUsersModels.getUserDetailsModel.GetUserDetailsResponse;
import restAPI.service.getUsers_Service.GetUsersService;

import static restAPI.conditions.Conditions.statusCode;
import static restAPI.properties.TokenProperty.TOKEN;

public class FactoryExample {
    private GetUsersService getUsersService = new GetUsersService();
    private int userID;

    public FactoryExample(int userID){
        this.userID = userID;
    }

    public FactoryExample() {
    }


    @Test
    public void getUser(){
        GetUserDetailsResponse response = getUsersService
                .getUserDetails(TOKEN, userID)
                .shouldHave(statusCode(200))
                .responseAs(GetUserDetailsResponse.class);

        int id = response.getData().getId();
        Assert.assertEquals(id, userID);
    }

    public class SimpleFactoryExample {
        @Factory
        public Object[] factoryMethod() {
            return new Object[]{
                    new FactoryExample(1542),
                    new FactoryExample(12)
            };
        }
    }
}
