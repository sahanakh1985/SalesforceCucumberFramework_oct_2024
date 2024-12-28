package com.training.steps;

import java.lang.reflect.Constructor;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.training.base.BasePage;
import com.training.base.BaseTest;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps extends BaseTest {

	WebDriver driver;
	BasePage page;

	@Given("User launch the application")
	public void user_launch_the_application() {
		driver = launchApplication();
	}

	@Given("User is on {string}")
	public void user_is_on(String pageName) {
		Class<?> className;
		Constructor<?> constructor;

		String packageName = "com.training.pages";
		String fullPath = packageName + "." + pageName;

		try {

			/*
			 * className = Class.forName(fullPath);
			 * constructor=className.getDeclaredConstructor(WebDriver.class);
			 * constructor.newInstance(driver);
			 */

			page = (BasePage) Class.forName(fullPath).getDeclaredConstructor(WebDriver.class).newInstance(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@When("User wait and enter into textbox {string} {string}")
	public void user_wait_and_enter_the_textbox(String elementName, String value) {
		page.waitAndEnterIntoTextbox(elementName, value);

	}

	@When("User enter into textbox {string} {string}")
	public void user_enter_the_textbox(String elementName, String value) {
		page.enterIntoTextbox(elementName, value);

	}

	@Then("User click on button {string}")
	public void user_click_on_button(String elementName) {
		page.clickOnButton(elementName);
	}

	@When("User wait and click on button {string}")
	public void user_wait_and_click_on_button(String elementName) {
		page.waitAndClickOnButton(elementName);
	}

	@Then("User close all the windows except parentWindow")
	public void user_close_all_the_windows_except_parent_window() {
		page.switchToNewWindowAndCloseThatWindow();
	}

	@Then("User verify the url {string} of page {string}")
	public void user_verify_the_url_of_page(String expectedUrl, String presentPage) {
		page.verifyTheUrl(expectedUrl, presentPage);
	}

	@Then("User verify the text {string} {string}")
	public void user_verify_the_text(String string, String string2) {
		page.validateText(string, string2);
	}

	@Given("User waits for {int} seconds")
	public void user_waits_for_seconds(int seconds) {
		page.waitInSeconds(seconds);
	}

	@When("User switch to frame {string}")
	public void user_switch_to_frame(String frameName) {
		page.switchToFrame(frameName);

	}

	@When("User switch to new window and close that window")
	public void user_switch_to_new_window_and_close_that_window() {
		page.switchToNewWindowAndCloseThatWindow();

	}

	@Given("User selects {string} by visible text from the dropdown {string}")
	public void user_selects_by_visible_text_from_the_dropdown(String value, String dropdownName) {
		page.selectByVisibleTextFromTheDropdown(value, dropdownName);

	}

	@Then("User click on ok button of alert popup")
	public void user_click_on_ok_button_of_alert_popup() {
		page.acceptAlert();
	}

	@When("User mouseover and click on button {string}")
	public void user_mouseover_and_click_on_button(String elementName) {
		page.mouseOverAndClick(elementName);
	}

	@When("User validate the title of {string} with {string}")
	public void user_validate_the_title_of_with(String pageName, String expectedTitle) {
		page.validateThePageTitle(pageName, expectedTitle);
	}
//
//	@Then("User validate the element list {string} {string}")
//	public void user_validate_the_element_list(String actualList, String expectedList) {
//		page.validateActualAndExpctedListFromDropdowns(actualList, expectedList);
//
//	}
	@Given("User selects  by index {int} of dropdown {string}")
	public void user_selects_by_index_of_dropdown(int index, String dropdown) {
	    page.selectByIndex(index,dropdown);
	}
	@Then("User get text from selected dropdown {string}")
	public void user_get_text_from_selected_dropdown(String dropdownName) {
	    page.getTextFromFirstSelectedDrodown(dropdownName);
	}
	@Then("User click on button {string} by JS")
	public void user_click_on_button_by_js(String elementName) {
	    page.clickOnButtonByJs(elementName);
	}
	@When("User gets the list of elements on {string}")
	public void user_gets_the_list_of_elements_on(String elementName) {
	   page.getElements(elementName);
	   
	}





	@After
	public void teardown(Scenario scenario) {
		byte[] screenshot = null;
		screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "Image/png", scenario.getName());
		driver.close();
		driver = null;
	}

}
