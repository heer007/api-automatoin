package zestbloom.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ExtendedPageObject extends PageObject {
    @FindBy(xpath = "//*[@id=\\\"body\\\"]/app-root/div/app-layout/div/app-menu/div/p-scrollpanel/div/div[1]/div/ul/li[1]")
    private WebElementFacade Theme;
    @FindBy(xpath = "//*[@id=\\\"body\\\"]/app-root/div/app-layout/div/app-menu/div/p-scrollpanel/div/div[1]/div/ul/li[2]")
    private WebElementFacade MyTrips;


    static Logger log = LoggerFactory.getLogger(ExtendedPageObject.class);

    public void waitForPageLoaded() throws InterruptedException {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        Thread.sleep(199);
        System.out.println("Waiting for Page Load");

    }

    public String getURL() throws InterruptedException {
        waitForPageLoaded();
        return getDriver().getCurrentUrl();
    }

    public String getURL1() throws InterruptedException {
        waitForPageLoaded();
//        withTimeoutOf(120, TimeUnit.SECONDS).waitForPresenceOf(By.xpath("//div/div/app-topbar/div/a[2]/i"));
        getDriver().manage().window().maximize();
        return getDriver().getCurrentUrl();
    }

    private WebElement findTheVisibleOne(By locator) {
        List<WebElement> allFound = this.getDriver().findElements(locator);
        log.info("Method: findTheVisibleOne() - Total found: " + allFound.size());
        WebElement visibleOne = null;
        for (WebElement webElement : allFound) {
            if (webElement.isDisplayed()) {
                log.info("visible one found: " + webElement.toString());
                visibleOne = webElement;
                break;
            }
        }
        return visibleOne;
    }

    public WebElement returnTheVisibleOne(By locator) throws InterruptedException {
        waitForPageLoaded();
        WebElement theVisibleOne = findTheVisibleOne(locator);
        if (theVisibleOne == null) {
            //try again after 2 second
            log.info("Trying again after 2 sec...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
//				System.err.println("Thread is interrupted when sleeping!!!");
                log.error("Thread is interrupted when sleeping!!!\n" + ex.toString(), ex);
            }
            theVisibleOne = findTheVisibleOne(locator);
            if (theVisibleOne == null)
                throw new InterruptedException("No visible element found");
        }
        log.info("Returning the visible one");
        return theVisibleOne;
    }

    public boolean get_Vehicle_details() {
        String txt = getDriver().findElement(By.cssSelector(".section-title.m-b-20")).getText();
        if (txt != null) {
            log.info("Vehicle details found.");
        } else {
            log.info("Vehicle details not found.");
        }
        return true;
    }
    public boolean get_partner_driver_list() {
        String txt = getDriver().findElement(By.className("ui-table-tbody")).getText();
        if (txt != null) {
            log.info("partner driver list found.");
        } else {
            log.info("partner driver list not found.");
        }
        return true;
    }

    public void clickTabs(String tabs) throws InterruptedException {
        waitForPageLoaded();
        String xpathExpression = "//span[@class='ui-tabview-title' and text()='" + tabs + "']";
        returnTheVisibleOne(By.xpath(xpathExpression)).click();
        Thread.sleep(2000);

    }

    public String getTripHistoryTabsText() throws InterruptedException {
        waitForPageLoaded();
        String txt = getDriver().findElement(By.xpath("//div[@class='col-lg-12']//h2")).getText();
        log.info("Tab_txt: " + txt);
        return txt;
    }

    public String getTripHistoryTabs_2_Text() throws InterruptedException {
        waitForPageLoaded();
        waitForPageLoaded();
        String head = getDriver().findElements(By.cssSelector(".col-lg-12")).get(3).getText();
//        log.info("Tab_txt: " + txt);
        return head;
    }

    public boolean getTripHistoryTabs_3_Text() throws InterruptedException {
        waitForPageLoaded();
        waitForPageLoaded();
        boolean txt = getDriver().findElement(By.xpath("//span[contains(text(),'Download')]")).isDisplayed();
        log.info("Tab_txt: " + txt);
        return txt;
    }

    public void clickOnActionIcon(String actionButtonName) throws Throwable{
        waitForPageLoaded();
        String xpathExpression = "(//button[@title='" + actionButtonName + "'])";
        int xpathCount = getDriver().findElements(By.xpath(xpathExpression)).size();
        System.out.println("number of field found "+xpathCount);
        if(xpathCount>0){
            String xpathExpression1 = "(//button[@title='" + actionButtonName + "'])[1]";
//            getDriver().findElement(By.xpath(xpathExpression1)).click();
            returnTheVisibleOne(By.xpath(xpathExpression1)).click();
            Thread.sleep(2000);
        }
        else {
            returnTheVisibleOne(By.xpath(xpathExpression)).click();
            Thread.sleep(2000);
        }
    }

    public void refreshBrowser() {
        getDriver().navigate().refresh();
    }
}
