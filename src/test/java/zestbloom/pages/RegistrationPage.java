package zestbloom.pages;

import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class RegistrationPage extends ExtendedPageObject {

    public void userClickOnLink(String arg0) {
        getDriver().findElement(By.xpath("//a[text()='Sign Up']")).click();
    }

    @FindBy(xpath = "//label[text()='Name']")
    WebElement nameLabel;
    public boolean userCanSeeTheRegistrationForm() {
       return  nameLabel.isDisplayed();
    }

    @FindBy(name = "firstName")
    WebElement firstName;
    @FindBy(name = "lastName")
    WebElement lastName;
    @FindBy(name = "username")
    WebElement user_name;
    @FindBy(name = "email")
    WebElement email_input;
    @FindBy(name = "password")
    WebElement password_input;
    @FindBy(name = "confirmPassword")
    WebElement passwordConfirm_input;
    public void userCanFillTheRegistrationFormWithBelowData(DataTable table) throws InterruptedException {

        List<List<String>> data = table.asLists(String.class);
        Random rnd = new Random();
        int num = 100000000 + rnd.nextInt(90000);
        char c = (char) (rnd.nextInt(26) + 'a');
        String email = "testzestbloom" + c + c + num + "@yopmail.com";
        TestDataSetup.setUserRegisterEmail(email);
        firstName.sendKeys(data.get(1).get(1));
        lastName.sendKeys(data.get(2).get(1));
        String username = data.get(3).get(1) + c + c + num;
        System.out.println(username);
        user_name.sendKeys(username);
        System.out.println(email);
        email_input.sendKeys(email);
        TestDataSetup.setUserPassword(data.get(4).get(1));
        password_input.sendKeys(data.get(4).get(1));
        passwordConfirm_input.sendKeys(data.get(5).get(1));
    }

    @FindBy(xpath = "//label[contains(@class,'form-checkbox')]")
    WebElementFacade termsAndPrivacy;
    public void userClickOnTermsOfServiceAndPrivacyPolicyCheckbox() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView();", termsAndPrivacy);
        termsAndPrivacy.click();
    }

    @FindBy(id = "verify-title")
    WebElementFacade verify_title;
    public boolean userCanSeePopup(String arg0) {
        return verify_title.getText().contains(arg0);
    }

    public void userOpenTheInTab(String url) {
        getDriver().get(url);
    }

    @FindBy(id = "login")
    WebElementFacade ycptInput;
    public void userTypeTheRegisteredEmailIntoTheInputField() throws InterruptedException {
        waitForPageLoaded();
        ycptInput.sendKeys(TestDataSetup.getUserRegisterEmail());
    }

    @FindBy(id = "refreshbut")
    WebElementFacade refreshbut;
    public void userClickOnCheckInboxButton() {
        refreshbut.click();
    }

    public boolean userCanSeeTheEmail(String arg0) throws InterruptedException {
        waitForPageLoaded();
        getDriver().switchTo().frame(getDriver().findElement(By.id("ifmail")));
        String str = getDriver().findElement(By.xpath("//div[@class='fl']")).getText();
        return str.contains(arg0);
    }

    public void userClickOnButtonToVerifyEmail(String arg0) {
        getDriver().findElement(By.xpath("//a[text()='Verify']")).click();
        getDriver().switchTo().defaultContent();
        ArrayList<String> tabs2 = new ArrayList<String> (getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs2.get(1));
    }

}
