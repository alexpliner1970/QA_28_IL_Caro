package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @BeforeMethod
    public void preconditions() {
        if (app.getHlpUser().iSeelogout())
            app.getHlpUser().logout();
    }

    @Test
    public void loginSuccess() {
        app.getHlpUser().openLoginForm();
        app.getHlpUser().fillLoginForm("sdf@wweb.com", "Wer34#64");
        app.getHlpUser().yallaLogin();

        Assert.assertEquals(app.getHlpUser().getMassege(), "Logged in success");

        app.getHlpUser().pause(3000);
        app.getHlpUser().click_Ok();


    }



//=====UnSuccessLogin

    @Test
    public void loginWrongPassword(){//1 "//h2[text()='"Login or Password incorrect"']"(2) text "Login or Password incorrect"
        app.getHlpUser().openLoginForm();
        app.getHlpUser().fillLoginForm("sdf@wweb.com", "Wer34#61");
        app.getHlpUser().yallaLogin();

        Assert.assertEquals(app.getHlpUser().getLoginPasswordIncorrect(),"\"Login or Password incorrect\"");

        app.getHlpUser().pause(3000);
        app.getHlpUser().click_Ok();


    }
    @Test
    public void loginEmptyPassword(){//2  "//div[text()=' Password is required ']", yalla "[type='submit'][disabled]"

        app.getHlpUser().openLoginForm();
        app.getHlpUser().fillLoginForm("sdf@wweb.com", "");

        app.getHlpUser().openLoginForm();
        System.out.println(app.getHlpUser().getPasswordIsRequired());

        Assert.assertEquals(app.getHlpUser().getPasswordIsRequired(),"Password is required");

        Assert.assertTrue(app.getHlpUser().yallaDis());

    }
    @Test
    public void loginWrongEmail(){//3 "//div[@class='error']/div", text It'snot look like email

        app.getHlpUser().openLoginForm();
        app.getHlpUser().fillLoginForm("com", "Wer34#64");

        Assert.assertTrue(app.getHlpUser().yallaDis());
        Assert.assertEquals(app.getHlpUser().getItsnotlooklikeEmail(),"It'snot look like email");

    }



    @Test
    public void loginUnregisteredUser(){//5 "//h2[text()='"Login or Password incorrect"']" text "Login or Password incorrect"

        app.getHlpUser().openLoginForm();
        app.getHlpUser().fillLoginForm("sdf@wwe.com", "Wer34#612");
        app.getHlpUser().yallaLogin();

        Assert.assertEquals(app.getHlpUser().getLoginPasswordIncorrect(),"\"Login or Password incorrect\"");

        app.getHlpUser().pause(3000);
        app.getHlpUser().click_Ok();
    }
    @Test
    public void loginEmptyEmail(){//4 "//div[@class=error]/div" ,text Email is required, yalla "[type='submit'][disabled]

        app.getHlpUser().openLoginForm();
        app.getHlpUser().fillLoginForm("", "Wer34#64");

        Assert.assertEquals(app.getHlpUser().getItsnotlooklikeEmail(),"Email is required");
        Assert.assertTrue(app.getHlpUser().yallaDis());
        System.out.println(app.getHlpUser().getItsnotlooklikeEmail());

    }
    @Test
    public void loginSuccess1() {
        User user = new User().setEmail("sdf@wweb.com").setPassword("Wer34#64");
        app.getHlpUser().openLoginForm();
        app.getHlpUser().fillLoginForm(user);
        app.getHlpUser().yallaLogin();

        Assert.assertEquals(app.getHlpUser().getMassege(), "Logged in success");

        app.getHlpUser().pause(3000);
        app.getHlpUser().click_Ok();

    }

    @AfterMethod
    public void postCondition(){
        app.getHlpUser().pause(3000);
        //app.getHlpUser().click_Ok();
    }
}
