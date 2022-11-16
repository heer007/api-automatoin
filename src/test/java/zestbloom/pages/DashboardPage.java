package zestbloom.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://google.co.in")
public class DashboardPage extends ExtendedPageObject {

    public void userClickOnProfileIcon() {
        getDriver().findElement(By.xpath("//li[@class='menu-link']")).click();
    }

    public void selectFromTheMenu(String arg0) {
        String xpath = "//a//span[text()='"+arg0+"']";
        getDriver().findElement(By.xpath(xpath)).click();
    }

    public String pageLoads(String arg0) {
        String currentURL = getDriver().getCurrentUrl();
        System.out.println("Checkout URL: " + currentURL);
        return currentURL;
    }

}
