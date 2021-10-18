package adapters;

import endpoints.DefectsEndpoints;
import io.restassured.response.Response;
import models.Defect;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;

public class DefectsAdapter extends  BaseAdapter{

    public Defect getAllDefects(String code) {
        Response response = given()
                .when()
                .get(String.format(DefectsEndpoints.GET_ALL_DEFECTS, code))
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        return gson.fromJson(response.asString().trim(), Defect.class);
    }


    public Defect getDefect(String code, int id) {
        Response response = given()
                .when()
                .get(String.format(DefectsEndpoints.GET_ONE_DEFECT, code, id))
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        return gson.fromJson(response.asString().trim(), Defect.class);
    }
}
