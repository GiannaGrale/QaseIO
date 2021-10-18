package tests;

import adapters.ResultAdapter;
import baseEntities.BaseAPITest;
import models.Result;
import org.testng.Assert;
import org.testng.annotations.Test;

public class API_Result_Test extends BaseAPITest {
    private final String code = "SHARELANE";
    private final int runID = 39;
    private String hashID;

    @Test(priority = 1)
    public void createRunTestResult() {
        Result newResult = Result.builder()
                .case_id(17)
                .status("in_progress")
                .build();
        Result createResult = new ResultAdapter().createTestResult(newResult, code, runID);
        hashID = createResult.getResult().getHash();
        Assert.assertNotNull(createResult.getResult());
    }

    @Test(priority = 2, dependsOnMethods = "createRunTestResult")
    public void getOneRunResult() {
        Result getOneResult = new ResultAdapter().getOneResult(code, hashID);
        Assert.assertEquals(getOneResult.getResult().getHash(), hashID);
    }

    @Test(priority = 4)
    public void getAllResultsOfRuns() {
        Result getResults = new ResultAdapter().getAllRunResults(code);
        Assert.assertEquals(getResults.getResult().getEntities()[0].getRun_id(), runID);
    }

    @Test(priority = 4, dependsOnMethods = "createRunTestResult")
    public void updateRunTestResult() {
        Result newResult = Result.builder()
                .case_id(17)
                .status("passed")
                .build();
        Result updateResult = new ResultAdapter().updateTestResult(newResult, code, runID, hashID);
        Assert.assertEquals(updateResult.getResult().getHash(), hashID);
    }

    @Test(priority = 5, dependsOnMethods = "createRunTestResult")
    public void deleteResult() {
        Result deleteResult = new ResultAdapter().deleteResult(code, runID, hashID);
        Assert.assertEquals(deleteResult.getResult().getHash(), hashID);
    }
}
