package tests;

import adapters.PlansAdapter;
import baseEntities.BaseAPITest;
import models.PLan;
import org.testng.Assert;
import org.testng.annotations.Test;


public class API_Plans_Test extends BaseAPITest {
    private int planID;

    @Test(priority = 1)
    public void createPlan() {
        PLan newPlan = PLan.builder()
                .title("Awesome plan")
                .description("Awesome plan")
                .cases(new int[]{16, 18})
                .build();
        PLan createPlan = new PlansAdapter().createPlan(newPlan, props.getProject());
        planID = createPlan.getResult().getId();
        Assert.assertTrue(createPlan.isStatus());
    }

    @Test
    public void getAllPlans() {
        PLan getAll = new PlansAdapter().getAllPlans(props.getProject());
        Assert.assertTrue(getAll.isStatus());
    }

    @Test(priority = 3)
    public void getOnePlan() {
        PLan getPlan = new PlansAdapter().getOnePlan(props.getProject(), planID);
        Assert.assertTrue(getPlan.isStatus());

    }

    @Test(priority = 2, dependsOnMethods = "createPlan")
    public void updatePlan() {
        PLan newPlan = PLan.builder()
                .title("Updated awesome plan")
                .description("Awesome plan")
                .cases(new int[]{20, 18})
                .build();
        PLan changedPlan = new PlansAdapter().updatePlan(newPlan, props.getProject(), planID);
        Assert.assertEquals(changedPlan.getResult().getId(), planID);

    }

    @Test(priority = 4, dependsOnMethods = "createPlan")
    public void deletePlan() {
        PLan deletedPlan = new PlansAdapter().deleteOnePlan(props.getProject(), planID);
        Assert.assertTrue(deletedPlan.isStatus());
    }
}
