package tests;

import core.ReadProperties;
import endpoints.ProjectsEndpoints;
import endpoints.UsersEndpoints;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Negative_Headers_API {
    protected final ReadProperties props = ReadProperties.getInstance();

    //401
    @Test
    public void setupRestAssured() {
        RestAssured.baseURI = props.getURL();
        RestAssured.requestSpecification = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .header("Token", props.getProject());

        given()
                .when()
                .get(UsersEndpoints.GET_ALL_USERS)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_UNAUTHORIZED);
    }
}
