package tests;

import baseEntities.BaseAPIProjectTest;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class API_Project_Test extends BaseAPIProjectTest {

    @Test
    public void getAllProjects() {
       String endpoint = "https://api.qase.io/v1/project";

        given()
                .when()
                .get(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }


    @Test
    public void getSpecificProject() {
        String endpoint = "https://api.qase.io/v1/project/DEMO";

        given()
                .when()
                .get(endpoint)
                .then()
                .body("result.title", equalTo("Demo Project"))
                .log().body().statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void CreateNewProject() {
        String endpoint = "https://api.qase.io/v1/project";
        Response response = given()
                .body("{\n" +
                        "  \"title\": \"Anna's API Project\",\n" +
                        "  \"code\": \"NEW\",\n" +
                        "  \"description\": \"Awesome project\",\n" +
                        "  \"access\": \"all\",\n" +
                        "  \"group\": null\n" +
                        "}")
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .extract().response();
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK);

    }
}