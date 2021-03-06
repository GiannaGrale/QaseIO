package baseEntities;

import core.ReadProperties;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.BeforeTest;

import static io.restassured.RestAssured.given;

public class BaseAPITest {
    protected final ReadProperties props = ReadProperties.getInstance();

    @BeforeTest
    public void setupRestAssured() {
        RestAssured.baseURI = ReadProperties.getInstance().getURL();
        RestAssured.requestSpecification = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .header("Token", ReadProperties.getInstance().getToken())
                .auth().preemptive().oauth2(ReadProperties.getInstance().getToken());

    }
}
