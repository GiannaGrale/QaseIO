package adapters;

import endpoints.PlansEndpoints;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.PLan;
import org.apache.http.HttpStatus;


import static io.restassured.RestAssured.given;

public class PlansAdapter extends BaseAdapter {

    public PLan getAllPlans(String code) {
        Response response = given()
                .when()
                .get(String.format(PlansEndpoints.GET_PLANS, code))
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        return gson.fromJson(response.asString().trim(), PLan.class);
    }

    public PLan getOnePlan(String code, int id) {
        Response response = given()
                .when()
                .get(String.format(PlansEndpoints.GET_SPECIFIC_PLAN, code, id))
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        return gson.fromJson(response.asString().trim(), PLan.class);
    }

    public PLan createPlan(PLan plan, String code) {
        Response response = given()
                .body(plan, ObjectMapperType.GSON)
                .when()
                .post(String.format(PlansEndpoints.CREATE_PLAN, code))
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        return gson.fromJson(response.asString().trim(), PLan.class);
    }

    public PLan updatePlan(PLan plan, String code, int id) {
        Response response = given()
                .body(plan, ObjectMapperType.GSON)
                .when()
                .patch(String.format(PlansEndpoints.UPDATE_PLAN, code, id))
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        return gson.fromJson(response.asString().trim(), PLan.class);
    }

    public PLan deleteOnePlan(String code, int id) {
        Response response = given()
                .when()
                .delete(String.format(PlansEndpoints.DELETE_PLAN, code, id))
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        return gson.fromJson(response.asString().trim(), PLan.class);
    }
}
