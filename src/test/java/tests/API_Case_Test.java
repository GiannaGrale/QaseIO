package tests;
import adapters.CaseAdapter;
import baseEntities.BaseAPITest;
import models.Case;
import org.testng.Assert;
import org.testng.annotations.Test;


public class API_Case_Test extends BaseAPITest{
    private final String code = "SHARELANE";
    private int caseID;


    @Test
    public void getAllCases() {
        Case getCases = new CaseAdapter().getAllCases(code);
         caseID = getCases.getResult().getEntities()[4].getId();
         Assert.assertEquals(getCases
                .getResult()
                .getEntities()[0]
                .getSteps()[0]
                .getAction(),
                "Зайти на главную страницу sharelane.com");
    }

    @Test(dependsOnMethods = "getAllCases")
    public void getCase() {
        Case getCases = new CaseAdapter().getCase(code, caseID);
        Assert.assertEquals(getCases.getResult().getPreconditions(),
                "Создан кабинет пользователя.");
    }
}
