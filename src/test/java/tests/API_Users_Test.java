package tests;

import baseEntities.BaseAPIUsersTest;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;


public class API_Users_Test extends BaseAPIUsersTest {

    @Test
    public void getAllUsers() {
        String endpoint = "https://api.qase.io/v1/user";

        given()
                .when()
                .get(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void getSpecificUser() {
        String endpoint = "https://api.qase.io/v1/user/1";

        given()
                .when()
                .get(endpoint)
                .then()
                .body("result.name", equalTo("Anna"))
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }
}