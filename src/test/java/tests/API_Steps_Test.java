package tests;

import adapters.SharedStepsAdapter;
import baseEntities.BaseAPITest;
import models.SharedSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

public class API_Steps_Test extends BaseAPITest {
    private String needed_Hash;
    private String stepTitle;

    @Test(priority = 1)
    public void createStep() {
        SharedSteps putStep = SharedSteps.builder()
                .title("My shared step")
                .action("open URL")
                .expected_result("URL is opened")
                .build();
        SharedSteps createdStep = new SharedStepsAdapter().createStep(putStep, props.getProject());
        needed_Hash = createdStep.getResult().getHash();
        Assert.assertTrue(createdStep.isStatus());
    }

    @Test(priority = 3, dependsOnMethods = "getSpecificStep")
    public void getAllSteps() {
        SharedSteps getSteps = new SharedStepsAdapter().getAllSteps(props.getProject());
        Assert.assertEquals(getSteps.getResult().getEntities()[0].getTitle(), stepTitle);
    }

    @Test(priority = 2, dependsOnMethods = "createStep")
    public void getSpecificStep() {
        SharedSteps getOneStep = new SharedStepsAdapter().getOneSteps(props.getProject(), needed_Hash);
        stepTitle = getOneStep.getResult().getTitle();
        Assert.assertEquals(getOneStep.getResult().getHash(), needed_Hash);
    }

    @Test(priority = 4, dependsOnMethods = "createStep")
    public void updateStep() {
        SharedSteps patchStep = SharedSteps.builder()
                .title("UpdatedStep")
                .action("close URL")
                .expected_result("URL is closed")
                .build();
        SharedSteps changedStep = new SharedStepsAdapter().updateStep(patchStep, props.getProject(), needed_Hash);
        Assert.assertTrue(changedStep.isStatus());
    }

    @Test(priority = 5, dependsOnMethods = "createStep")
    public void deleteSpecificStep() {
        SharedSteps deletedStep = new SharedStepsAdapter().deleteStep(props.getProject(), needed_Hash);
        Assert.assertEquals(deletedStep.getResult().getHash(), needed_Hash);
    }
}
