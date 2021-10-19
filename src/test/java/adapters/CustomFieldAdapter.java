package adapters;

import endpoints.CustomFieldEndpoints;
import io.restassured.response.Response;
import models.CustomField;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;

public class CustomFieldAdapter extends BaseAdapter {

    public CustomField getAllCustomFields(String code) {
        Response response = given()
                .when()
                .get(String.format(CustomFieldEndpoints.GET_ALL_CUSTOM_FIELDS, code))
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        return gson.fromJson(response.asString().trim(), CustomField.class);
    }
}
