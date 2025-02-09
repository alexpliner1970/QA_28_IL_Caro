package manager;

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
}
