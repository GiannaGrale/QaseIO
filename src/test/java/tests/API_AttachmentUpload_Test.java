package tests;

import adapters.AttachmentAdapter;
import core.ReadProperties;
import endpoints.AttachmentEndpoint;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.Attachment;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class API_AttachmentUpload_Test {
    private final ReadProperties props = ReadProperties.getInstance();
    private String hashID;
    private final Path f = Paths.get(props.getPicture());
    private final String path = f.toAbsolutePath().normalize().toString();


    @Test(invocationCount = 2)
    public void createAttachment() {
        Response resp = RestAssured.given()
                .multiPart("jpg", new File(path))
                .header("Token", props.getToken())
                .auth().preemptive().oauth2(props.getToken())
                .when()
                .post(String.format(AttachmentEndpoint.UPLOAD_ATTACHMENT, props.getProject()))
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .and().log().body().extract().response();
        hashID = resp.getBody().jsonPath().get("result[0].hash").toString();

    }

    @Test(dependsOnMethods = "createAttachment")
    public void deleteAttachment() {
        RestAssured.baseURI = props.getURL();
        RestAssured.requestSpecification = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .header("Token", props.getToken())
                .auth().preemptive().oauth2(props.getToken());

        Attachment deleteAttachment = new AttachmentAdapter().deleteAttachment(hashID);
        Assert.assertEquals(deleteAttachment.getResult().getHash(), hashID);
    }
}
