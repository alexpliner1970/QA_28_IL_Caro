package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HelperBase {

    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }
    public void type(By locator,String text){
        WebElement elem = wd.findElement(locator);
        elem.click();
        elem.clear();
        if (text!=null)
            elem.sendKeys(text);
    }
    public void clickOn(By locator){
        wd.findElement(locator).click();
    }

    public boolean isElementPresent(By locator){
        List<WebElement> list=wd.findElements(locator);
        return list.size()>0;
    }
}