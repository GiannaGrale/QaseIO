package adapters;

import endpoints.RunEndpoints;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.Runs;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;

public class RunsAdapter extends  BaseAdapter {

    public Runs getAllRuns(String code) {
        Response response = given()
                .when()
                .get(String.format(RunEndpoints.GET_ALL_TEST_RUNS, code))
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body()
                .extract().response();
        return gson.fromJson(response.asString().trim(), Runs.class);
    }

    public Runs getSpecificRun(String code, int id) {
        Response response = given()
                .when()
                .get(String.format(RunEndpoints.GET_ONE_TEST_RUN, code, id))
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body()
                .extract().response();
        return gson.fromJson(response.asString().trim(), Runs.class);
    }

    public Runs createRun(Runs run, String code) {
        Response response = given()
                .body(run, ObjectMapperType.GSON)
                .when()
                .post(String.format(RunEndpoints.CREATE_TEST_RUN, code))
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body()
                .extract().response();
        return gson.fromJson(response.asString().trim(), Runs.class);
    }

    public Runs deleteRun(String code, int id) {
        Response response = given()
                .when()
                .delete(String.format(RunEndpoints.DELETE_TEST_RUN, code, id))
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body()
                .extract().response();
        return gson.fromJson(response.asString().trim(), Runs.class);
    }
}
