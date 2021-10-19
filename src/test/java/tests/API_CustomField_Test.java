package tests;

import adapters.CustomFieldAdapter;
import baseEntities.BaseAPITest;
import models.CustomField;
import org.testng.Assert;
import org.testng.annotations.Test;

public class API_CustomField_Test extends BaseAPITest {
    private final String code = "SHARELANE";

    @Test
    public void getFields() {
        CustomField getAllFields = new CustomFieldAdapter().getAllCustomFields(code);
        Assert.assertEquals(getAllFields.getResult().getTotal(), 0);
    }
}
