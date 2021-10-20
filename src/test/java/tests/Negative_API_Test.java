package tests;


import baseEntities.BaseAPITest;
import endpoints.SuitesEndpoints;
import endpoints.WrongEndpoints;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;

public class Negative_API_Test extends BaseAPITest {

    //404
    @Test
    public void getInvalidUsers() {
        given()
                .when()
                .get(WrongEndpoints.GET_ALL_INVALID_USERS)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_NOT_FOUND)
                .extract().response();
    }

    //400
    @Test
    public void getInvalidSuites() {
        given()
                .when()
                .post(String.format(SuitesEndpoints.ALL_SUITES, props.getProject()))
                .then()
                .log().body().assertThat()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .extract().response();

    }
}
