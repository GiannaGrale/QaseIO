package adapters;

import endpoints.ProjectsEndpoints;
import endpoints.SharedStepsEndpoints;
import io.restassured.response.Response;
import models.SharedSteps;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;

public class SharedStepsAdapter extends  BaseAdapter{

    public SharedSteps getAllSteps(String code) {
        Response response = given()
                .when()
                .get(String.format(SharedStepsEndpoints.GET_ALL_STEPS, code))
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body()
                .extract().response();
        return gson.fromJson(response.asString().trim(), SharedSteps.class);
    }

    public SharedSteps createStep(SharedSteps steps, String code) {
        Response response = given()
                .body(steps)
                .when()
                .post(String.format(SharedStepsEndpoints.POST_STEP, code))
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body()
                .extract().response();
        return gson.fromJson(response.asString().trim(), SharedSteps.class);
    }

    public SharedSteps getOneSteps(String code, String hash) {
        Response response = given()
                .when()
                .get(String.format(SharedStepsEndpoints.GET_SPECIFIC_STEP, code, hash))
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body()
                .extract().response();
        return gson.fromJson(response.asString().trim(), SharedSteps.class);
    }

    public SharedSteps updateStep(SharedSteps steps, String code, String hash) {
        Response response = given()
                .body(steps)
                .when()
                .patch(String.format(SharedStepsEndpoints.UPDATE_STEP, code, hash))
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body()
                .extract().response();
        return gson.fromJson(response.asString().trim(), SharedSteps.class);
    }

    public SharedSteps deleteStep(String code, String hash) {
        Response response = given()
                .when()
                .delete(String.format(SharedStepsEndpoints.DELETE_STEP, code, hash))
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body()
                .extract().response();
        return gson.fromJson(response.asString().trim(), SharedSteps.class);
    }
}
