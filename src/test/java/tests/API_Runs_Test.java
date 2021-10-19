package tests;

import adapters.RunsAdapter;
import baseEntities.BaseAPITest;
import models.Runs;
import org.testng.Assert;
import org.testng.annotations.Test;


public class API_Runs_Test extends BaseAPITest {
    private int runID;

    // limit is 2 runs
    @Test(priority = 1)
    public void createRun() {
        Runs newRun = Runs.builder()
                .title(props.getMilestoneTitle())
                .description("Awesome run by API")
                .environment_id(null)
                .cases(new int[]{17, 20})
                .build();
        Runs postRun = new RunsAdapter().createRun(newRun, props.getProject());
        runID = postRun.getResult().getId();
        Assert.assertNotNull(postRun.getResult());
    }

    @Test(priority = 2, dependsOnMethods = "createRun")
    public void getOneRun() {
        Runs oneRun = new RunsAdapter().getSpecificRun(props.getProject(), runID);
        Assert.assertEquals(oneRun.getResult().getTitle(), props.getMilestoneTitle());
    }

    @Test(priority = 3, dependsOnMethods = "createRun")
    public void getAllRuns() {
        Runs getRuns = new RunsAdapter().getAllRuns(props.getProject());
        Assert.assertEquals(getRuns.getResult().getEntities()[0].getTitle(), props.getMilestoneTitle());
    }

    @Test(priority = 4, dependsOnMethods = "createRun")
    public void deleteRun() {
        Runs deletedRun = new RunsAdapter().deleteRun(props.getProject(), runID);
        Assert.assertEquals(deletedRun.getResult().getId(), runID);
    }
}
