package tests;

import adapters.DefectsAdapter;
import baseEntities.BaseAPITest;
import models.Defect;
import org.testng.Assert;
import org.testng.annotations.Test;

public class API_Defects_Test extends BaseAPITest {
    private final String code = "SHARELANE";
    private  final int defectID =3;


    @Test
    public void getAllDefects() {
        Defect getAllDefect = new DefectsAdapter().getAllDefects(code);
        Assert.assertEquals(getAllDefect.getResult().getEntities()[1].getId(), defectID);
    }

    @Test
    public void getOneDefects() {
        Defect getDefect = new DefectsAdapter().getDefect(code, defectID);
        Assert.assertEquals(getDefect.getResult().getId(), defectID);
    }
}
