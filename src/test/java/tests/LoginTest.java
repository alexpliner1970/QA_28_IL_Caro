package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    @BeforeMethod
   public void preconditions(){
        if(app.getHlpUser().iSeelogout())
           app.getHlpUser().logout();
    }

    @Test
    public void loginSuccess(){
        app.getHlpUser().openLoginForm();
        app.getHlpUser().fillLoginForm("sdf@wweb.com","Wer34#64");
        app.getHlpUser().yallaLogin();

        Assert.assertTrue(app.getHlpUser().loggetOk());

        app.getHlpUser().click_Ok();
        Assert.assertTrue(app.getHlpUser().iSeelogout());

    }

    @Test
    public void loginSuccessModel(){
        app.getHlpUser().openLoginForm();
        app.getHlpUser().fillLoginForm("sdf@wweb.com","Wer34#64");
        app.getHlpUser().yallaLogin();

        Assert.assertTrue(app.getHlpUser().loggetOk());

        app.getHlpUser().click_Ok();
        Assert.assertTrue(app.getHlpUser().iSeelogout());

    }
}
