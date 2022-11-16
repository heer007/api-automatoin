package zestbloom.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

@DefaultUrl("https://google.co.in")
public class LandingPage extends ExtendedPageObject {


    public void openURL() throws InterruptedException {
        String url = "https://testnet.zestbloom.com/";

        getDriver().get(url);
    }

    public void quitBrowser()  {
        getDriver().quit();
    }

    @FindBy(name = "email")
    WebElementFacade email;

    public void setEmail(String strEmail) throws InterruptedException {
        waitForRenderedElementsToBePresent(By.name("email"));
        email.sendKeys(strEmail);
    }

    @FindBy(name = "password")
    WebElementFacade pass;

    public void setPassword(String strPasss) throws InterruptedException {
//        waitForPageLoaded();
        pass.sendKeys(strPasss);
        Thread.sleep(199);
    }

    @FindBy(xpath = "//button//span[text()='Sign In']")
    WebElement loginbtn;

    public void clickLoginBtn() throws InterruptedException {
//        waitForPageLoaded();
        loginbtn.click();
        waitForPageLoaded();
    }

    @FindBy(xpath = "//li[@class='menu-link']")
    WebElement menu_link;
    public boolean home_page_is_displayed() throws InterruptedException {
        waitForPageLoaded();
        Thread.sleep(199);
        return menu_link.isDisplayed();
    }

    public void user_click_on_button(String string) throws InterruptedException {
        waitForPageLoaded();
        String xpath = "//button//span[text()='"+string+"']";
        getDriver().findElement(By.xpath(xpath)).click();
    }

    public void userTryToLoginUsingRegisteredEmailAndPassword() throws InterruptedException {
        waitForRenderedElementsToBePresent(By.name("email"));
        email.sendKeys(TestDataSetup.getUserRegisterEmail());
        pass.sendKeys(TestDataSetup.getUserPassword());
        Thread.sleep(199);
    }

}
