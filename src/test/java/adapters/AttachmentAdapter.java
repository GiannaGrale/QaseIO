package adapters;

import endpoints.AttachmentEndpoint;
import io.restassured.response.Response;
import models.Attachment;
import org.apache.http.HttpStatus;


import static io.restassured.RestAssured.given;

public class AttachmentAdapter extends BaseAdapter {

    public Attachment getAllAttachments() {
        Response response = given()
                .when()
                .get(AttachmentEndpoint.GET_ALL_ATTACHMENTS)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        return gson.fromJson(response.asString().trim(), Attachment.class);
    }

    public Attachment getOneAttachment(String hash) {
        Response response = given()
                .when()
                .get(String.format(AttachmentEndpoint.GET_SPECIFIC_ATTACHMENT, hash))
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        return gson.fromJson(response.asString().trim(), Attachment.class);
    }

    public Attachment deleteAttachment(String hash) {
        Response response = given()
                .when()
                .delete(String.format(AttachmentEndpoint.DELETE_ATTACHMENT, hash))
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        return gson.fromJson(response.asString().trim(), Attachment.class);
    }
}
