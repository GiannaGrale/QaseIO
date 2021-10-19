package tests;

import adapters.CustomFieldAdapter;
import baseEntities.BaseAPITest;
import models.CustomField;
import org.testng.Assert;
import org.testng.annotations.Test;

public class API_CustomField_Test extends BaseAPITest {

    @Test
    public void getFields() {
        CustomField getAllFields = new CustomFieldAdapter().getAllCustomFields(props.getProject());
        Assert.assertEquals(getAllFields.getResult().getTotal(), 0);
    }
}
