package adapters;

import endpoints.MilestonesEndpoints;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import models.Milestone;
import org.apache.http.HttpStatus;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class MilestonesAdapter extends BaseAdapter {

    public Milestone getAllMilestones(String code) {
        Response response = given()
                .when()
                .get(String.format(MilestonesEndpoints.GET_ALL_MILESTONES, code))
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        return gson.fromJson(response.asString().trim(), Milestone.class);
    }

    public int getMilestoneSize(String code) {
        JsonPath response = given()
                .when()
                .get(String.format(MilestonesEndpoints.GET_ALL_MILESTONES, code))
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response().jsonPath();
        return response.get("result.total");

    }

    public Milestone getSpecificMilestone(String code, int id) {
        Response response = given()
                .when()
                .get(String.format(MilestonesEndpoints.GET_SPECIFIC_MILESTONE, code, id))
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        return gson.fromJson(response.asString().trim(), Milestone.class);
    }

    public Milestone createMilestone(String code, Milestone milestone) {
        Response response = given()
                .body(milestone, ObjectMapperType.GSON)
                .when()
                .post(String.format(MilestonesEndpoints.CREATE_MILESTONE, code))
                .then()
                .log().body()
                .extract().response();
        return gson.fromJson(response.asString().trim(), Milestone.class);
    }

    public Milestone updateMilestone(Map<String, Object> jsonAs, String code, int id) {
        Response response = given()
                .body(jsonAs)
                .when()
                .patch(String.format(MilestonesEndpoints.UPDATE_MILESTONE, code, id))
                .then()
                .log().body()
                .extract().response();
        return gson.fromJson(response.asString().trim(), Milestone.class);
    }

    public Milestone deleteMilestone(String code, int id) {
        Response response = given()
                .when()
                .delete(String.format(MilestonesEndpoints.DELETE_MILESTONE, code, id))
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        return gson.fromJson(response.asString().trim(), Milestone.class);
    }
}
