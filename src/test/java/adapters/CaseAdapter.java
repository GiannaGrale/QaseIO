package adapters;

import endpoints.CasesEndpoints;
import io.restassured.response.Response;
import models.Case;
import org.apache.http.HttpStatus;


import static io.restassured.RestAssured.given;

public class CaseAdapter extends BaseAdapter {

    public Case getAllCases(String code) {
        Response response = given()
                .when()
                .get(String.format(CasesEndpoints.GET_ALL_CASES, code))
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        return gson.fromJson(response.asString().trim(), Case.class);
    }

    public Case getCase(String code, int id) {
        Response response = given()
                .when()
                .get(String.format(CasesEndpoints.GET_SPECIFIC_CASE, code, id))
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        return gson.fromJson(response.asString().trim(), Case.class);
    }
}
