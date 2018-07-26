package com.quantum.steps;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.quantum.utils.DriverUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class mobileTesting {

	AppiumDriver 	driver;
	WebDriverWait	wait;
	String 			os;
	final int 		interval = 30000; // The interval of time to watch the trailer. *currently 30 seconds.
	
	//TODO: Change my user , password and host cloud URL.
	final String user = "dinesh.venkataraman@internal.53.com";
	final String pass = "Perfecto123";
	final String host = "fifththird.perfectomobile.com";
	
	@BeforeTest
	public void beforTest() throws MalformedURLException{

		try{
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("user", user);
			capabilities.setCapability("password", pass);
			capabilities.setCapability("model", "iPhone-8 Plus");
			capabilities.setCapability("platformName", "iOS");
			capabilities.setCapability("platformVersion", "11.4");
			capabilities.setCapability("autoAcceptAlerts",true);
			driver = new AndroidDriver(new URL("https://" + this.host + "/nexperience/perfectomobile/wd/hub"), capabilities) ;
					
			wait = new WebDriverWait(driver, 10);
			driver.context("NATIVE_APP");
			driver.manage().timeouts().implicitlyWait(15 , TimeUnit.SECONDS);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test(priority=1)	
	public void OpenAPP(){
				
		HashMap<String , Object> script = new HashMap<String, Object>();
		script.put("name", "Fifth Third");
		driver.executeScript("mobile:application:open", script);
		System.out.println("---------------------------->App is opened");

		System.out.println("---------------------------->Touch Action is performed");
		
	}
	
	
	@Test(priority=2)	
	public void enterUsernamePassword() throws Exception
	{
		Thread.sleep(1200);
		driver.findElement(By.xpath("//device/view/group[1]/group[1]/group[1]/group[1]/group[1]/group[1]/view[1]/group[1]/group[1]/group[1]/group[2]/textfield[1]")).click();
		//Thread.sleep(1200);
		//driver.findElement(By.className("XCUIElementTypeTextField")).click();
		System.out.println("I got clicked");
		//driver.findElement(By.xpath("AppiumAUT/XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeTextField[1]")).sendKeys("1212121");
	}

	
	
	
}
