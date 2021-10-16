package tests;

import baseEntities.BaseAPITest;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class API_Milestone_Test extends BaseAPITest {

    @Test
    public void getAllMilestones() {
        String endpoint = "https://api.qase.io/v1/case/SHARELANE";

        given()
                .when()
                .get(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void getSpecificMilestone() {
        String endpoint = "https://api.qase.io/v1/case/SHARELANE/13";

        given()
                .when()
                .get(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }


    @Test
    public void deleteMilestone() {
        String endpoint = "https://api.qase.io/v1/case/SHARELANE/24";

        given()
                .when()
                .delete(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }
}