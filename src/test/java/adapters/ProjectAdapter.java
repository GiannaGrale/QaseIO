package adapters;

import endpoints.ProjectsEndpoints;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.Project;
import org.apache.http.HttpStatus;


import static io.restassured.RestAssured.given;


public class ProjectAdapter extends BaseAdapter {

    public Project getAllProjects() {
        Response response = given()
                .when()
                .get(ProjectsEndpoints.GET_ALL_PROJECTS)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body()
                .extract().response();
        return gson.fromJson(response.asString().trim(), Project.class);
    }

    public Project getProject(String code) {
        Response response = given()
                .when()
                .get(String.format(ProjectsEndpoints.GET_SPECIFIC_PROJECT, code))
                .then()
                .log().body().statusCode(HttpStatus.SC_OK)
                .extract().response();
        return gson.fromJson(response.asString().trim(), Project.class);
    }

    public Project postProject(Project createProject) {
        Response response = given()
                .body(createProject, ObjectMapperType.GSON)
                .when()
                .post(ProjectsEndpoints.CREATE_PROJECT)
                .then()
                .log().body()
                .extract().response();
        return gson.fromJson(response.asString().trim(), Project.class);
    }
}

