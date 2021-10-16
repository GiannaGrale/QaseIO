package tests;


import adapters.MilestonesAdapter;
import baseEntities.BaseAPITest;
import models.Milestone;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;



public class API_Milestone_Test extends BaseAPITest {
    private final String code = "SHARELANE";
    int milestoneID;

    @Test
    public void getAllMilestones() {
        Milestone milestone = new MilestonesAdapter().getAllMilestones(code);
        Assert.assertEquals(milestone.getResult().getTotal(), new MilestonesAdapter().getMilestoneSize(code));
    }

    @Test(dependsOnMethods = "createMilestone")
    public void getSpecificMilestone() {
        Milestone getMilestone = new MilestonesAdapter().getSpecificMilestone(code, milestoneID);
        Assert.assertNull(getMilestone.getResult().getDescription());
    }

    @Test(priority = 1)
    public void createMilestone() {
        Milestone putMilestone = Milestone.builder()
                .title("I am a milestone").build();
        Milestone createMilestone = new MilestonesAdapter().createMilestone(code, putMilestone);
        milestoneID = createMilestone.getResult().getId();
        Assert.assertTrue(createMilestone.isStatus());
    }

    @Test(priority = 2, dependsOnMethods = "createMilestone")
    public void updateMilestone() {
        Milestone newMilestone = Milestone.builder()
                .title("updated milestone")
                .description("updates description")
                .build();

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("title", newMilestone.getTitle());
        jsonAsMap.put("description", newMilestone.getTitle());

        Milestone updatedMilestone = new MilestonesAdapter().updateMilestone(jsonAsMap, code, milestoneID);
        Assert.assertTrue(updatedMilestone.isStatus());
    }

    @Test(priority = 3, dependsOnMethods = "createMilestone")
    public void deleteMilestone() {
        Milestone deletedMilestone = new MilestonesAdapter().deleteMilestone(code, milestoneID);
        Assert.assertEquals(deletedMilestone.getResult().getId(), milestoneID);
    }
}