package tests;

import adapters.ProjectAdapter;
import baseEntities.BaseAPITest;
import models.Project;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Randoms;


public class API_Project_Test extends BaseAPITest {
    private final Randoms random = new Randoms();
    private String code;

    private final Project putProject = Project.builder()
            .title(random.generatedString)
            .code(random.generatedString)
            .description(random.generatedString)
            .access("all")
            .group(null)
            .build();

    @Test(priority = 1)
    public void createNewProjectTest() {
        Project createdProject = new ProjectAdapter().postProject(putProject);
        code = createdProject.getResult().getCode();
        Assert.assertEquals(createdProject.getResult().getCode().toLowerCase(), putProject.getCode().toLowerCase());
    }

    @Test
    public void getAllProjects() {
        Project allProjects = new ProjectAdapter().getAllProjects();
        Assert.assertEquals(allProjects.getResult().getEntities()[1].getCode(), props.getProject());
    }

    @Test(priority = 2, dependsOnMethods = "createNewProjectTest")
    public void getProjectAdapterTest() {
        Project receivedProject = new ProjectAdapter().getProject(code);
        Assert.assertEquals(receivedProject.getResult().getCounts().getCases(), putProject.getCases());
    }
}