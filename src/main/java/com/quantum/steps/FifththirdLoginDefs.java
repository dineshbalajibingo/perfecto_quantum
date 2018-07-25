package com.quantum.steps;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.utils.AppiumUtils;
import com.quantum.utils.ConfigurationUtils;
import com.quantum.utils.ConsoleUtils;
import com.quantum.utils.DeviceUtils;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

@QAFTestStepProvider
public class FifththirdLoginDefs {
	
	private static WebDriverTestBase webDriverTestBase = new WebDriverTestBase();

    private static QAFExtendedWebDriver getDriver(){
        return webDriverTestBase.getDriver();
    }
	
	
	@Given("^I start the application by the name \"([^\"]*)\"$")
	public void i_start_the_application_by_the_name(String name) throws Throwable {
		Map<String, Object> params = new HashMap<>();
		params.put("name", name);
		getDriver().executeScript("mobile:application:open", params);

	}
	
 

	@Given("^I am using AppiumDriver$")
	public void i_am_using_AppiumDriver() throws Throwable {
		if (ConfigurationUtils.getBaseBundle().getPropertyValue("driver.name").contains("Remote"))
			ConsoleUtils.logWarningBlocks("Driver is an instance of QAFExtendedWebDriver");
		else if (AppiumUtils.getAppiumDriver() instanceof IOSDriver)
			ConsoleUtils.logWarningBlocks("Driver is an instance of IOSDriver");
		else if (AppiumUtils.getAppiumDriver() instanceof AndroidDriver)
			ConsoleUtils.logWarningBlocks("Driver is an instance of AndroidDriver");
	}
	
	@Given("^user is in login page$")
	public void user_is_in_login_page() throws Throwable {
	   System.out.println("I am in login Page now");
	}

	@When("^I enter \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_enter_and(String arg1, String arg2) throws Throwable {
		
		new QAFExtendedWebElement("input.userdidtxt").click();


	
	}

	@When("^I click on login button$")
	public void i_click_on_login_button() throws Throwable {
		//new QAFExtendedWebElement("btn.login").click();
	}

	@Then("^I get an error message \"([^\"]*)\"$")
	public void i_get_an_error_message(String arg1) throws Throwable {

	}

	@Given("^User is in login Page$")
	public void user_is_in_login_Page() throws Throwable {
	
	}

	@Given("^I click on locations$")
	public void i_click_on_locations() throws Throwable {
	 
	}

	@Given("^I enter the Zip code$")
	public void i_enter_the_Zip_code() throws Throwable {
	  
	}

	@Then("^I get all ATM nearby$")
	public void i_get_all_ATM_nearby() throws Throwable {
	
	}


}
