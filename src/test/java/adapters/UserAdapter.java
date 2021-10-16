package adapters;

import endpoints.UsersEndpoints;
import io.restassured.response.Response;
import models.User;
import org.apache.http.HttpStatus;
import static io.restassured.RestAssured.given;


public class UserAdapter extends  BaseAdapter{

    public User getAllUsers() {
        Response response = given()
                .when()
                .get(UsersEndpoints.GET_ALL_USERS)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        return gson.fromJson(response.asString().trim(), User.class);
    }

    public User getSpecificUser(int id) {
        Response response = given()
                .when()
                .get(String.format(UsersEndpoints.GET_SPECIFIC_USER, id))
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        return gson.fromJson(response.asString().trim(), User.class);
    }
}
