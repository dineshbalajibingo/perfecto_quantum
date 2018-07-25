package com.quantum.steps;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.utils.DeviceUtils;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

@QAFTestStepProvider
public class FifththirdWebDefs {
	
    

	@Given("^I open the browser and enter URL$")
	public void i_open_the_browser_and_enter_URL() throws Throwable {
	
		new WebDriverTestBase().getDriver().get("https://www.53.com/content/fifth-third/en.html");
		System.out.println("Run started");

		
	}

	@Given("^I input \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_input_and(String arg1, String arg2) throws Throwable {
		
		QAFExtendedWebElement userBoxElement = new QAFExtendedWebElement("input.userID");
		userBoxElement.click();
		Actions actions = new Actions(new WebDriverTestBase().getDriver());
		Thread.sleep(2000);
		actions.sendKeys(arg1);
		System.out.println("Password is " +arg1);
		actions.build().perform();
		Thread.sleep(1200);
		QAFExtendedWebElement pwdBoxElement = new QAFExtendedWebElement("input.pwd");
		pwdBoxElement.click();
		Actions actionsC = new Actions(new WebDriverTestBase().getDriver());
		Thread.sleep(2000);
		actionsC.sendKeys(arg2);
		System.out.println("Password is " +arg2);
		actionsC.build().perform();
		
	}

	@Given("^I click on login button on screen$")
	public void i_click_on_login_button_on_screen() throws Throwable {
		
		QAFExtendedWebElement loginBtnElement = new QAFExtendedWebElement("clk.login");
		JavascriptExecutor js = (JavascriptExecutor) DeviceUtils.getQAFDriver();
		js.executeScript("arguments[0].click();", loginBtnElement);
	
	}

	@Then("^I get an error message \"([^\"]*)\" on screen$")
	public void i_get_an_error_message_on_screen(String arg1) throws Throwable {
		QAFExtendedWebElement errorText = new QAFExtendedWebElement("text.errorMsg");
		errorText.getText();
		Thread.sleep(2000);
		System.out.println("*************** Error Text is "+errorText.getText());
		errorText.assertText("User ID and password invalid.");
		
	 
	}
	
	@Given("^I click login$")
	public void i_click_login() throws Throwable {
		QAFExtendedWebElement loginElement = new QAFExtendedWebElement("btn.login");
		loginElement.click();
	}

}
