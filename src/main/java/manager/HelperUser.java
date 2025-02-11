package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperUser extends HelperBase {

    public HelperUser(WebDriver wd) {
        super(wd);
    }
    public void openLoginForm(){
        //WebElement log_in = wd.findElement(By.xpath("//a[@href='/login?url=%2Fsearch']"));
        //log_in.click();
        clickOn(By.xpath("//a[@href='/login?url=%2Fsearch']"));
    }

    public void fillLoginForm(String email, String password) {
//        WebElement emailInput= wd.findElement(By.cssSelector("[autocomplete='username']"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys(email);
        type(By.cssSelector("[autocomplete='username']"),email);

//        WebElement passwordInput =wd.findElement(By.id("password"));
//        passwordInput.click();
//        passwordInput.clear();
//        passwordInput.sendKeys(password);
        type(By.id("password"),password);
    }

    public void fillLoginForm(User user) {
        type(By.cssSelector("[autocomplete='username']"),user.getEmail());
        type(By.id("password"),user.getPassword());
    }

    public void yallaLogin(){
           clickOn(By.xpath("//*[text()='Y’alla!']"));
    }



    public void click_Ok(){
        clickOn(By.xpath("//*[text()='Ok']"));
    }

    public boolean iSeelogout() {
       return isElementPresent(By.cssSelector("[href='/logout?url=%2Fsearch']"));
    }

    public void logout() {
        clickOn(By.cssSelector("[href='/logout?url=%2Fsearch']"));
    }

    public String getMassege() {
       // pause(2000);
        WebElement element=wd.findElement(By.cssSelector(".dialog-container>h2"));
        String text =element.getText();
        return text;

    }
    public String getLoginPasswordIncorrect(){
        return wd.findElement(By.xpath("//h2[text()='\"Login or Password incorrect\"']")).getText();

    }
    public String getPasswordIsRequired(){
        return wd.findElement(By.xpath("//div[text()=' Password is required ']")).getText();//dont use
    }
    public boolean yallaDis(){
        return isElementPresent(By.cssSelector("[type='submit'][disabled]"));
    }
    public String getItsnotlooklikeEmail(){
        return wd.findElement(By.xpath("//div[@class='error']/div")).getText();
    }


}
