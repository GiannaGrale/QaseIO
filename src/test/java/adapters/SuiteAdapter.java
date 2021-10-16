package adapters;

import endpoints.SuitesEndpoints;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import models.Suite;
import org.apache.http.HttpStatus;

import java.util.Map;

import static io.restassured.RestAssured.given;


public class SuiteAdapter extends BaseAdapter {

    public Suite getAllSuites(String code) {
        Response response = given()
                .when()
                .get(String.format(SuitesEndpoints.ALL_SUITES, code))
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        return gson.fromJson(response.asString().trim(), Suite.class);
    }


    public Suite getSpecificSuite(String code, int id) {
        Response response = given()
                .when()
                .get(String.format(SuitesEndpoints.GET_SPECIFIC_SUITE, code, id))
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        return gson.fromJson(response.asString().trim(), Suite.class);
    }

    public Suite postNewSuite(String code, Suite suite) {
        Response response = given()
                .body(suite, ObjectMapperType.GSON)
                .when()
                .post(String.format(SuitesEndpoints.POST_SUITE, code))
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        return gson.fromJson(response.asString().trim(), Suite.class);
    }

    public Suite updateSuite(String code, int id, Map<String, Object> jsonAs) {
        Response response = given()
                .body(jsonAs)
                .when()
                .patch(String.format(SuitesEndpoints.UPDATE_SUITE, code, id))
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        return gson.fromJson(response.asString().trim(), Suite.class);
    }


    public int countSuites(String code) {
        JsonPath response = given()
                .when()
                .get(String.format(SuitesEndpoints.ALL_SUITES, code))
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response().jsonPath();
        return response.get("result.entities.size()");
    }

    public Suite deleteSuite(String code, int id) {
        Response response = given()
                .when()
                .delete(String.format(SuitesEndpoints.DELETE_SUITE, code, id))
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        return gson.fromJson(response.asString().trim(), Suite.class);
    }
}
