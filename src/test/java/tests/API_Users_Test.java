package tests;

import adapters.UserAdapter;
import baseEntities.BaseAPITest;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;


public class API_Users_Test extends BaseAPITest {
    int userID;

    @Test
    public void getAllUsers() {
        User allUsers = new UserAdapter().getAllUsers();
        userID = allUsers.getResult().getEntities()[0].getId();
        String title = "Teacher";
        Assert.assertEquals(allUsers.getResult().getEntities()[1].getTitle(), title);
    }

    @Test(dependsOnMethods = "getAllUsers")
    public void getSpecificUser() {
        User allUsers = new UserAdapter().getSpecificUser(userID);
        String name = "Anna";
        Assert.assertEquals(allUsers.getResult().getName(), name);
    }
}