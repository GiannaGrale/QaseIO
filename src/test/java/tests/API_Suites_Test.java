package tests;

import adapters.SuiteAdapter;
import baseEntities.BaseAPITest;
import endpoints.SuitesEndpoints;
import models.Suite;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Randoms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import static io.restassured.RestAssured.given;

public class API_Suites_Test extends BaseAPITest {
    Randoms random = new Randoms();
    private final String code = "SHARELANE";
    private final String title = "Test suite title";
    private int createSuiteID;


    @Test
    public void getAllSuitesFirstTest() {
        Suite suite = Suite.builder()
                .title(title)
                .build();
        Suite allSuites = new SuiteAdapter().getAllSuites(code);
        Assert.assertEquals(allSuites.getResult().getEntities()[2].getTitle(), suite.getTitle());
    }

    @Test
    public void getSizeTest() {
        List<String> titlesSize = given()
                .when()
                .get(String.format(SuitesEndpoints.ALL_SUITES, code))
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().body().jsonPath().getList("result.entities.title");
        Assert.assertEquals(titlesSize.size(), new SuiteAdapter().countSuites(code));

    }

    @Test(priority = 2, dependsOnMethods = "postNewSuite")
    public void getSpecificSuite() {
        Suite specificSuite = new SuiteAdapter().getSpecificSuite(code, createSuiteID);
        Assert.assertTrue(specificSuite.isStatus());
    }

    @Test(priority = 1)
    public void postNewSuite() {
        Suite postSuite = Suite.builder()
                .title(random.generatedString)
                .description(random.generatedString)
                .parent_id(random.i)
                .preconditions(random.generatedString)
                .build();
        Suite createdSuite = new SuiteAdapter().postNewSuite(code, postSuite);
        createSuiteID = createdSuite.getResult().getId();
    }


    @Test(priority = 3, dependsOnMethods = "postNewSuite")
    public void updateSuite() {
        Suite updateSuite = Suite.builder()
                .title(random.generatedString)
                .description(random.generatedString)
                .parent_id(random.i)
                .preconditions(random.generatedString)
                .build();

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("title", updateSuite.getTitle());
        jsonAsMap.put("parent_id", updateSuite.getParent_id());
        jsonAsMap.put("description", updateSuite.getDescription());
        jsonAsMap.put("preconditions", updateSuite.getPreconditions());
        Suite updatesSuite = new SuiteAdapter().updateSuite(code, createSuiteID, jsonAsMap);
        Assert.assertTrue(updatesSuite.isStatus());

    }

    @Test(priority = 4, dependsOnMethods = "postNewSuite")
    public void deleteSuite() {
        Suite deletedSuite = new SuiteAdapter().deleteSuite(code, createSuiteID);
        Assert.assertTrue(deletedSuite.isStatus());

    }
}
