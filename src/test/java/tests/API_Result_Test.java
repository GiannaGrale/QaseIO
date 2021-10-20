package tests;

import adapters.ResultAdapter;
import baseEntities.BaseAPITest;
import models.Result;
import org.testng.Assert;
import org.testng.annotations.Test;


public class API_Result_Test extends BaseAPITest {
    private String hashID;

    @Test(priority = 1)
    public void createRunTestResult() {
        Result newResult = Result.builder()
                .case_id(17)
                .status("in_progress")
                .build();
        Result createResult = new ResultAdapter().createTestResult(newResult, props.getProject(), props.getRunID());
        hashID = createResult.getResult().getHash();
        Assert.assertNotNull(createResult.getResult());
    }

    @Test(priority = 2, dependsOnMethods = "createRunTestResult")
    public void getOneRunResult() {
        Result getOneResult = new ResultAdapter().getOneResult(props.getProject(), hashID);
        Assert.assertEquals(getOneResult.getResult().getHash(), hashID);
    }

    @Test(priority = 4)
    public void getAllResultsOfRuns() {
        Result getResults = new ResultAdapter().getAllRunResults(props.getProject());
        Assert.assertEquals(getResults.getResult().getEntities()[0].getRun_id(), props.getRunID());
    }

    @Test(priority = 4, dependsOnMethods = "createRunTestResult")
    public void updateRunTestResult() {
        Result newResult = Result.builder()
                .case_id(17)
                .status("passed")
                .build();
        Result updateResult = new ResultAdapter().updateTestResult(newResult, props.getProject(), props.getRunID(), hashID);
        Assert.assertEquals(updateResult.getResult().getHash(), hashID);
    }

    @Test(priority = 5, dependsOnMethods = "createRunTestResult")
    public void deleteResult() {
        Result deleteResult = new ResultAdapter().deleteResult(props.getProject(), props.getRunID(), hashID);
        Assert.assertEquals(deleteResult.getResult().getHash(), hashID);
    }
}
