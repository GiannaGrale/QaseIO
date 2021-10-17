package tests;

import adapters.SharedStepsAdapter;
import baseEntities.BaseAPITest;
import models.SharedSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

public class API_Steps_Test extends BaseAPITest {
    private final String code = "SHARELANE";
    private final String title = "My shared step";
    private String needed_Hash;


    @Test(priority = 1)
    public void createStep() {
        SharedSteps putStep = SharedSteps.builder()
                .title(title)
                .action("open URL")
                .expected_result("URL is opened")
                .build();
        SharedSteps createdStep = new SharedStepsAdapter().createStep(putStep, code);
        needed_Hash = createdStep.getResult().getHash();
        Assert.assertTrue(createdStep.isStatus());
    }

    @Test(priority = 3)
    public void getAllSteps() {
        SharedSteps getSteps = new SharedStepsAdapter().getAllSteps(code);
        Assert.assertEquals(getSteps.getResult().getEntities()[0].getTitle(), title);
    }

    @Test(priority = 2, dependsOnMethods = "createStep")
    public void getSpecificStep() {
        SharedSteps getOneStep = new SharedStepsAdapter().getOneSteps(code, needed_Hash);
        Assert.assertEquals(getOneStep.getResult().getHash(), needed_Hash);
    }

    @Test(priority = 4, dependsOnMethods = "createStep")
    public void updateStep() {
        SharedSteps patchStep = SharedSteps.builder()
                .title("UpdatedStep")
                .action("close URL")
                .expected_result("URL is closed")
                .build();
        SharedSteps changedStep = new SharedStepsAdapter().updateStep(patchStep, code, needed_Hash);
        Assert.assertTrue(changedStep.isStatus());
    }

    @Test(priority = 5, dependsOnMethods = "createStep")
    public void deleteSpecificStep() {
        SharedSteps deletedStep = new SharedStepsAdapter().deleteStep(code, needed_Hash);
        Assert.assertEquals(deletedStep.getResult().getHash(), needed_Hash);
    }
}
