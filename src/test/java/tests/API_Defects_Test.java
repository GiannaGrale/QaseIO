package tests;

import adapters.DefectsAdapter;
import baseEntities.BaseAPITest;
import models.Defect;
import org.testng.Assert;
import org.testng.annotations.Test;

public class API_Defects_Test extends BaseAPITest {

    @Test
    public void getAllDefects() {
        Defect getAllDefect = new DefectsAdapter().getAllDefects(props.getProject());
        Assert.assertEquals(getAllDefect.getResult().getEntities()[1].getId(), props.getDefectID());
    }

    @Test
    public void getOneDefects() {
        Defect getDefect = new DefectsAdapter().getDefect(props.getProject(), props.getDefectID());
        Assert.assertEquals(getDefect.getResult().getId(), props.getDefectID());
    }
}
