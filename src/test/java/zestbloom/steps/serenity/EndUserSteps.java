package zestbloom.steps.serenity;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Step;
import zestbloom.pages.*;
import org.junit.Assert;
import zestbloom.pages.ExtendedPageObject;
import zestbloom.pages.LandingPage;
import org.junit.Assume;

import java.awt.*;
import java.util.List;

public class EndUserSteps extends ExtendedPageObject {

	LandingPage landingPage;
	RegistrationPage registrationPage;
	DashboardPage dashboardPage;

	@Step
	public void user_is_on_landing_page() throws InterruptedException {
		landingPage.openURL();
	}

	@Step
	public void closeBrowser() {
		 landingPage.quitBrowser();
	}

	@Step
	public void user_enter_username_and_password_as_and_click_Login_button(String arg1, String arg2)
			throws InterruptedException {
		landingPage.setEmail(arg1);
		landingPage.setPassword(arg2);
		landingPage.clickLoginBtn();
	}

	@Step
	public void home_page_is_displayed() throws InterruptedException {
		Assert.assertEquals(true,  landingPage.home_page_is_displayed());
	}

	@Step
	public void user_click_on_button(String string) throws InterruptedException {
		landingPage.user_click_on_button(string);
	}

	@Step
	public void userCanSeeTheRegistrationForm() {
		Assert.assertTrue(registrationPage.userCanSeeTheRegistrationForm());
	}

	@Step
	public void userClickOnLink(String arg0) {
		registrationPage.userClickOnLink(arg0);
	}

	@Step
	public void userCanFillTheRegistrationFormWithBelowData(DataTable data) throws InterruptedException {
		registrationPage.userCanFillTheRegistrationFormWithBelowData(data);
	}

	@Step
	public void userClickOnTermsOfServiceAndPrivacyPolicyCheckbox() {
		registrationPage.userClickOnTermsOfServiceAndPrivacyPolicyCheckbox();
	}

	@Step
	public void userCanSeePopup(String arg0) {
		Assert.assertTrue(registrationPage.userCanSeePopup(arg0));
	}

	@Step
	public void userOpenTheInTab(String url) {
		registrationPage.userOpenTheInTab(url);
	}

	@Step
	public void userTypeTheRegisteredEmailIntoTheInputField() throws InterruptedException {
		registrationPage.userTypeTheRegisteredEmailIntoTheInputField();
	}

	@Step
	public void userClickOnCheckInboxButton() {
		registrationPage.userClickOnCheckInboxButton();
	}

	@Step
	public void userCanSeeTheEmail(String arg0) throws InterruptedException {
		registrationPage.userCanSeeTheEmail(arg0);
	}

	@Step
	public void userClickOnButtonToVerifyEmail(String arg0) {
		registrationPage.userClickOnButtonToVerifyEmail(arg0);
	}

	@Step
	public void userTryToLoginUsingRegisteredEmailAndPassword() throws InterruptedException {
		landingPage.userTryToLoginUsingRegisteredEmailAndPassword();
		landingPage.clickLoginBtn();
	}

	@Step
	public void userClickOnProfileIcon() {
		dashboardPage.userClickOnProfileIcon();
	}

	@Step
	public void selectFromTheMenu(String arg0) {
		dashboardPage.selectFromTheMenu(arg0);
	}

	@Step
	public void pageLoads(String arg0) {
	}

}







