package zestbloom.stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import zestbloom.steps.serenity.EndUserSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import io.cucumber.datatable.DataTable;
import org.junit.After;


public class DefinitionSteps {

	@Steps
	EndUserSteps steps;

    @After
    public void closeBrowser() {
        steps.closeBrowser();
    }

	@Given("^user is on landing page$")
	public void user_is_on_landing_page() throws InterruptedException {
		steps.user_is_on_landing_page();
	}

	@Given("^user enter username \"([^\"]*)\" and password as \"([^\"]*)\" and click Login button$")
	public void user_enter_username_and_password_as_and_click_Login_button(String arg1, String arg2)
			throws InterruptedException {
		steps.user_enter_username_and_password_as_and_click_Login_button(arg1, arg2);

	}

	@Then("^home page is displayed$")
	public void home_page_is_displayed() throws InterruptedException {
		steps.home_page_is_displayed();

	}

	@Given("user click on {string} button")
	public void user_click_on_button(String string) throws InterruptedException {
		steps.user_click_on_button(string);
	}


	@Then("user can see the registration form")
	public void userCanSeeTheRegistrationForm() {
    	steps.userCanSeeTheRegistrationForm();
	}

	@And("user click on {string} link")
	public void userClickOnLink(String arg0) {
    	steps.userClickOnLink(arg0);
	}

	@And("user can fill the registration form with below data")
	public void userCanFillTheRegistrationFormWithBelowData(DataTable data) throws InterruptedException {
    	steps.userCanFillTheRegistrationFormWithBelowData(data);
	}

	@And("user click on Terms of Service and Privacy Policy checkbox")
	public void userClickOnTermsOfServiceAndPrivacyPolicyCheckbox() {
    	steps.userClickOnTermsOfServiceAndPrivacyPolicyCheckbox();
	}

	@Then("user can see {string} popup")
	public void userCanSeePopup(String arg0) {
    	steps.userCanSeePopup(arg0);
	}

	@And("user open the {string} in tab")
	public void userOpenTheInTab(String url) {
    	steps.userOpenTheInTab(url);
	}

	@And("user type the registered email into the input field")
	public void userTypeTheRegisteredEmailIntoTheInputField() throws InterruptedException {
    	steps.userTypeTheRegisteredEmailIntoTheInputField();
	}

	@And("user click on Check Inbox button")
	public void userClickOnCheckInboxButton() {
    	steps.userClickOnCheckInboxButton();
	}

	@Then("user can see the {string} email")
	public void userCanSeeTheEmail(String arg0) throws InterruptedException {
    	steps.userCanSeeTheEmail(arg0);
	}

	@And("user click on {string} button to verify email")
	public void userClickOnButtonToVerifyEmail(String arg0) {
		steps.userClickOnButtonToVerifyEmail(arg0);
	}

	@And("user try to Login using registered Email and password")
	public void userTryToLoginUsingRegisteredEmailAndPassword() throws InterruptedException {
    	steps.userTryToLoginUsingRegisteredEmailAndPassword();
	}

	@When("user click on Profile icon")
	public void userClickOnProfileIcon() {
    	steps.userClickOnProfileIcon();
	}

	@And("select {string} from the menu")
	public void selectFromTheMenu(String arg0) {
    	steps.selectFromTheMenu(arg0);
	}

	@Then("{string} page loads")
	public void pageLoads(String arg0) {
    	steps.pageLoads(arg0);
	}
}
