package tests;

import adapters.AttachmentAdapter;
import baseEntities.BaseAPITest;
import models.Attachment;
import org.testng.Assert;
import org.testng.annotations.Test;



public class API_Attachment_Test extends BaseAPITest {
    private String hashID;

    @Test()
    public void allAttachments() {
        Attachment getAllAttachments = new AttachmentAdapter().getAllAttachments();
        hashID = getAllAttachments.getResult().getEntities()[0].getHash();
        Assert.assertEquals(getAllAttachments.getResult().getEntities()[0].getMime(), "application/octet-stream");
    }

    @Test(dependsOnMethods = "allAttachments")
    public void specificAttachment() {
        Attachment getOneAttachment = new AttachmentAdapter().getOneAttachment(hashID);
        Assert.assertEquals(getOneAttachment.getResult().getHash(), hashID);
    }
}
