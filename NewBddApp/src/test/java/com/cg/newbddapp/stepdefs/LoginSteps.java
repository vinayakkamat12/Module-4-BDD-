package com.cg.newbddapp.stepdefs;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.cg.newbddapp.pagebean.LoginPageBean;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class LoginSteps {

	WebDriver driver;
	private LoginPageBean objhlpg;

	@Given("^User is on login page$")
	public void user_is_on_login_page() throws Throwable {
		

		/*System.setProperty("webdriver.chrome.driver", "C:/StudyMaterial/BDD/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();*/
		
		System.setProperty("webdriver.gecko.driver", ".//Driver//geckodriver.exe");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		objhlpg = new LoginPageBean(driver);

			
		driver.get("file:///C:/MyData/VarshaBDD/NewBddApp/HTMLPages/login.html");
		
	   /*File relative = new File("NewBddApp/HTMLPages/login.html");
		driver.get("file:/"+relative.getPath());*/
	}

	@Then("^check the heading of the page$")
	public void check_the_heading_of_the_page() throws Throwable {
		String actualTitle = driver.findElement(By.xpath("//*[@id='mainCnt']/div[1]/div[1]/h1")).getText();
		
		String expectedTitle="Hotel Booking";
		
		if(expectedTitle.equals(actualTitle))
			System.out.println("Page Heading Matched...");
		else
			System.out.println("Page Heading does not matched...");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	}

	@When("^user enters valid username, valid password$")
	public void user_enters_valid_username_valid_password() throws Throwable {
	    objhlpg.setPfuname("capgemini");
	    Thread.sleep(1000);
	    objhlpg.setPfpwd("capg1234");
	    Thread.sleep(1000);
	    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	    objhlpg.setPflogin();
	  
	}

	@Then("^navigate to hotelBooking$")
	public void navigate_to_hotelBooking() throws Throwable {
		
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   driver.navigate().to("file:///C:/MyData/VarshaBDD/NewBddApp/HTMLPages/hotelbooking.html");
		/*File relative = new File("NewBddApp/HTMLPages/hotelbooking.html");
		driver.get("file:/"+relative.getPath());*/
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	  
	}

	@When("^user doesnot enter either username or password$")
	public void user_doesnot_enter_either_username_or_password() throws Throwable {
	    objhlpg.setPfuname("capgemini");	Thread.sleep(1000);
	    objhlpg.setPfpwd("");	Thread.sleep(1000);
	}

	@When("^clicks the Login Button$")
	public void clicks_the_Login_Button() throws Throwable {
	    objhlpg.setPflogin();
	}

	@Then("^display appropriate message$")
	public void display_appropriate_message() throws Throwable {
	   String alertMessage = driver.switchTo().alert().getText();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
	    System.out.println("******" + alertMessage);
	    driver.close();
	}
	 
}
