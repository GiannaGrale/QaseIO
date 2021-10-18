package adapters;

import endpoints.ResultsEndpoints;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.Result;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;

public class ResultAdapter extends  BaseAdapter{

    public Result getAllRunResults(String code) {
        Response response = given()
                .when()
                .get(String.format(ResultsEndpoints.GET_ALL_RUN_RESULTS, code))
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body()
                .extract().response();
        return gson.fromJson(response.asString().trim(), Result.class);
    }

    public Result createTestResult(Result result, String code, int id) {
        Response response = given()
                .body(result, ObjectMapperType.GSON)
                .when()
                .post(String.format(ResultsEndpoints.ADD_RUN_RESULT, code, id))
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body()
                .extract().response();
        return gson.fromJson(response.asString().trim(), Result.class);
    }

    public Result updateTestResult(Result result, String code, int id, String hash) {
        Response response = given()
                .body(result, ObjectMapperType.GSON)
                .when()
                .patch(String.format(ResultsEndpoints.UPDATE_RUN_RESULT, code, id, hash))
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body()
                .extract().response();
        return gson.fromJson(response.asString().trim(), Result.class);
    }


    public Result getOneResult(String code, String hash) {
        Response response = given()
                .when()
                .get(String.format(ResultsEndpoints.GET_SPECIFIC_RUN_RESULT, code, hash))
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body()
                .extract().response();
        return gson.fromJson(response.asString().trim(), Result.class);
    }

    public Result deleteResult(String code, int id, String hash) {
        Response response = given()
                .when()
                .delete(String.format(ResultsEndpoints.DELETE_RUN_RESULT, code, id, hash))
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body()
                .extract().response();
        return gson.fromJson(response.asString().trim(), Result.class);
    }
}
