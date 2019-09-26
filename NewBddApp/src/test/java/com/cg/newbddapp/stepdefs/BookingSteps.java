package com.cg.newbddapp.stepdefs;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.cg.newbddapp.pagebean.BookingPageBean;

import cucumber.api.DataTable;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class BookingSteps {

	private WebDriver driver;
	private BookingPageBean objhbpg;
	
	@Given("^User is on hotel booking page$")
	public void user_is_on_hotel_booking_page() throws Throwable {
		//driver = new FirefoxDriver();
		
		/*System.setProperty("webdriver.chrome.driver", "C:/StudyMaterial/BDD/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();*/
		
		System.setProperty("webdriver.gecko.driver", ".//Driver//geckodriver.exe");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
		driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		objhbpg = new BookingPageBean(driver);
		driver.get("file:///C:/MyData/VarshaBDD/NewBddApp/HTMLPages/hotelbooking.html");
	}

	@Then("^check the title of the page$")
	public void check_the_title_of_the_page() throws Exception {
		String title=driver.getTitle();
		if(title.contentEquals("Hotel Booking")) 
			System.out.println("Page Title Matched");
		else System.out.println("Page Title NOT Matched");
		driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
		driver.close();
	}

	@When("^user enters all valid data$")
	public void user_enters_all_valid_data() throws Exception {
		objhbpg.setPffname("Varsha");	Thread.sleep(1000);
		objhbpg.setPflname("Lonkar");	Thread.sleep(1000);
		objhbpg.setPfemail("varsha.r.lonkar@gmail.com");	Thread.sleep(1000);
		objhbpg.setPfmobile("7798825022");	Thread.sleep(1000);
		objhbpg.setPfcity("Pune");	Thread.sleep(1000);
		objhbpg.setPfstate("Maharashtra");	Thread.sleep(1000);
		objhbpg.setPfpersons(5);	Thread.sleep(1000);
		objhbpg.setPfcardholder("Varsha Lonkar");	Thread.sleep(1000);
		objhbpg.setPfdebit("4018061238126688");	Thread.sleep(1000);
		objhbpg.setPfcvv("297");	Thread.sleep(1000);
		objhbpg.setPfmonth("5");	Thread.sleep(1000);
		objhbpg.setPfyear("2023"); 
		driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
		objhbpg.setPfbutton();
		//driver.close();
	}

	
	@Then("^navigate to welcome page$")
	public void navigate_to_welcome_page() throws Exception {
		driver.navigate().to("file:///C:/MyData/VarshaBDD/NewBddApp/HTMLPages/success.html");
		driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
		//driver.close();
	}
	
	@When("^user leaves first Name blank$")
	public void user_leaves_first_Name_blank() throws Exception {
		objhbpg.setPffname("");	Thread.sleep(1000);
		
	}

	@When("^clicks the button$")
	public void clicks_the_button() throws Throwable {
		objhbpg.setPfbutton();
	}

	@Then("^display alert msg$")
	public void display_alert_msg() throws Exception {
		String alertMessage = driver.switchTo().alert().getText();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
	    System.out.println("******" + alertMessage);
	    driver.close();
	}

	@When("^user leaves last Name blank and clicks the button$")
	public void user_leaves_last_Name_blank_and_clicks_the_button() throws Exception {
		objhbpg.setPffname("Varsha");	Thread.sleep(1000);
		objhbpg.setPflname("");	Thread.sleep(1000);
		objhbpg.setPfbutton();
		
	}
	
	@When("^user enters all data$")
	public void user_enters_all_data() throws Exception {
		objhbpg.setPffname("Varsha");	Thread.sleep(1000);
		objhbpg.setPflname("Lonkar");	Thread.sleep(1000);
		objhbpg.setPfemail("varsha.r.lonkargmail.com");	Thread.sleep(1000);
		objhbpg.setPfmobile("7798825022");	Thread.sleep(1000);
		objhbpg.setPfcity("Pune");	Thread.sleep(1000);
		objhbpg.setPfstate("Maharashtra");	Thread.sleep(1000);
		objhbpg.setPfpersons(5);	Thread.sleep(1000);
		objhbpg.setPfcardholder("Varsha Lonkar");	Thread.sleep(1000);
		objhbpg.setPfdebit("4018061238126688");	Thread.sleep(1000);
		objhbpg.setPfcvv("297");	Thread.sleep(1000);
		objhbpg.setPfmonth("5");	Thread.sleep(1000);
		objhbpg.setPfyear("2023"); 
		objhbpg.setPfbutton();
		
	}

	@But("^user enters incorrect email format and clicks the button$")
	public void user_enters_incorrect_email_format_and_clicks_the_button() throws Exception {
		objhbpg.setPfemail("varsha.r.lonkargmail.com");	Thread.sleep(1000);
		objhbpg.setPfbutton();
	}

	@When("^user leaves MobileNo blank and clicks the button$")
	public void user_leaves_MobileNo_blank_and_clicks_the_button() throws Exception {
		objhbpg.setPffname("Varsha");	Thread.sleep(1000);
		objhbpg.setPflname("Lonkar");	Thread.sleep(1000);
		objhbpg.setPfemail("varsha.r.lonkar@gmail.com");	Thread.sleep(1000);
		objhbpg.setPfmobile("");	Thread.sleep(1000);
		objhbpg.setPfbutton();
	}

	@When("^user enters incorrect mobileNo format and clicks the button$")
	public void user_enters_incorrect_mobileNo_format_and_clicks_the_button(DataTable arg1) throws Exception {
		objhbpg.setPffname("Varsha");	Thread.sleep(1000);
		objhbpg.setPflname("Lonkar");	Thread.sleep(1000);
		objhbpg.setPfemail("varsha.r.lonkar@gmail.com");	
		Thread.sleep(1000);
				
		List<String> objList = arg1.asList(String.class);
		objhbpg.setPfbutton();
		
		for(int i=0; i<objList.size(); i++) {
			if(Pattern.matches("^[7-9]{1}[0-9]{9}$", objList.get(i))) {
			System.out.println("***** Valid phone number as per pattern" + objList.get(i) + "*****");
			}
			else {
				System.out.println("***** InValid phone number as per pattern" + objList.get(i) + "*****");
			}
		}
		
	}

	@When("^user doesnot select city$")
	public void user_doesnot_select_city() throws Exception {
		objhbpg.setPffname("Varsha");	Thread.sleep(1000);
		objhbpg.setPflname("Lonkar");	Thread.sleep(1000);
		objhbpg.setPfemail("varsha.r.lonkar@gmail.com");	Thread.sleep(1000);
		objhbpg.setPfmobile("7798825022");	Thread.sleep(1000);
		objhbpg.setPfcity("Select City");	Thread.sleep(1000);
		objhbpg.setPfbutton();
	}

	@When("^user doesnot select state$")
	public void user_doesnot_select_state() throws Exception {
		objhbpg.setPffname("Varsha");	Thread.sleep(1000);
		objhbpg.setPflname("Lonkar");	Thread.sleep(1000);
		objhbpg.setPfemail("varsha.r.lonkar@gmail.com");	Thread.sleep(1000);
		objhbpg.setPfmobile("7798825022");	Thread.sleep(1000);
		objhbpg.setPfcity("Pune");	Thread.sleep(1000);
		objhbpg.setPfstate("Select State");	Thread.sleep(1000);
		objhbpg.setPfbutton();
	}

	@When("^user enters (\\d+)$")
	public void user_enters(int arg1) throws Exception {
		objhbpg.setPffname("Varsha");	Thread.sleep(1000);
		objhbpg.setPflname("Lonkar");	Thread.sleep(1000);
		objhbpg.setPfemail("varsha.r.lonkar@gmail.com");	Thread.sleep(1000);
		objhbpg.setPfmobile("7798825022");	Thread.sleep(1000);
		objhbpg.setPfcity("Pune");	Thread.sleep(1000);
		objhbpg.setPfstate("Maharashtra");	Thread.sleep(1000);
		objhbpg.setPfpersons(arg1);	Thread.sleep(2000);
	}

	@Then("^allocate rooms such that (\\d+) room for minimum (\\d+) guests$")
	public void allocate_rooms_such_that_room_for_minimum_guests(int arg1, int arg2) throws Throwable {
		if(arg2 <=3) {
	    	System.out.println("***** 1 room");
	    	assertEquals(1, arg1);
	    }
	    else if(arg2 <=6){
	    	System.out.println("***** 2 rooms");
	    	assertEquals(2, arg1); 	
	    }	 
	    else if(arg2 <=9){
	    	System.out.println("***** 3 rooms");
	    	assertEquals(3, arg1); 	
	    }
		
	}

	
	@When("^user leaves CardHolderName blank and clicks the button$")
	public void user_leaves_CardHolderName_blank_and_clicks_the_button() throws Exception {
		objhbpg.setPffname("Varsha");	Thread.sleep(1000);
		objhbpg.setPflname("Lonkar");	Thread.sleep(1000);
		objhbpg.setPfemail("varsha.r.lonkar@gmail.com");	Thread.sleep(1000);
		objhbpg.setPfmobile("7798825022");	Thread.sleep(1000);
		objhbpg.setPfcity("Pune");	Thread.sleep(1000);
		objhbpg.setPfstate("Maharashtra");	Thread.sleep(1000);
		objhbpg.setPfpersons(7);	Thread.sleep(1000);
		objhbpg.setPfcardholder("");	Thread.sleep(1000);
		objhbpg.setPfbutton();
	}

	@When("^user leaves DebitCardNo blank and clicks the button$")
	public void user_leaves_DebitCardNo_blank_and_clicks_the_button() throws Exception {
		objhbpg.setPffname("Varsha");	Thread.sleep(1000);
		objhbpg.setPflname("Lonkar");	Thread.sleep(1000);
		objhbpg.setPfemail("varsha.r.lonkar@gmail.com");	Thread.sleep(1000);
		objhbpg.setPfmobile("7798825022");	Thread.sleep(1000);
		objhbpg.setPfcity("Pune");	Thread.sleep(1000);		
		objhbpg.setPfstate("Maharashtra");	Thread.sleep(1000);	
		objhbpg.setPfpersons(7);	Thread.sleep(1000);	
		objhbpg.setPfcardholder("Varsha Lonkar");	Thread.sleep(1000);
		objhbpg.setPfdebit("");	Thread.sleep(1000);
		objhbpg.setPfbutton();
	}

	@When("^user leaves expirationMonth blank and clicks the button$")
	public void user_leaves_expirationMonth_blank_and_clicks_the_button() throws Exception {
		objhbpg.setPffname("Varsha");	Thread.sleep(1000);
		objhbpg.setPflname("Lonkar");	Thread.sleep(1000);
		objhbpg.setPfemail("varsha.r.lonkar@gmail.com");	Thread.sleep(1000);
		objhbpg.setPfmobile("7798825022");	Thread.sleep(1000);
		objhbpg.setPfcity("Pune");	Thread.sleep(1000);		
		objhbpg.setPfstate("Maharashtra");	Thread.sleep(1000);	
		objhbpg.setPfpersons(7);	Thread.sleep(1000);	
		objhbpg.setPfcardholder("Varsha Lonkar");	Thread.sleep(1000);
		objhbpg.setPfdebit("4018061238126688");	Thread.sleep(1000);
		objhbpg.setPfcvv("297");	Thread.sleep(1000);
		objhbpg.setPfmonth("");	Thread.sleep(1000);
		objhbpg.setPfbutton();
	}

	@When("^user leaves expirationYr blank and clicks the button$")
	public void user_leaves_expirationYr_blank_and_clicks_the_button() throws Exception {
		objhbpg.setPffname("Varsha");	Thread.sleep(1000);
		objhbpg.setPflname("Lonkar");	Thread.sleep(1000);
		objhbpg.setPfemail("varsha.r.lonkar@gmail.com");	Thread.sleep(1000);
		objhbpg.setPfmobile("7798825022");	Thread.sleep(1000);
		objhbpg.setPfcity("Pune");	Thread.sleep(1000);		
		objhbpg.setPfstate("Maharashtra");	Thread.sleep(1000);	
		objhbpg.setPfpersons(7);	Thread.sleep(1000);	
		objhbpg.setPfcardholder("Varsha Lonkar");	Thread.sleep(1000);
		objhbpg.setPfdebit("4018061238126688");	Thread.sleep(1000);
		objhbpg.setPfcvv("297");	Thread.sleep(1000);
		objhbpg.setPfmonth("5");	Thread.sleep(1000);
		objhbpg.setPfyear("");	Thread.sleep(1000);
		objhbpg.setPfbutton();
	}
	
/*	@When("^user enters all data$")
	public void user_enters_all_data() throws Exception {
		objhbpg.setPffname("Varsha");	Thread.sleep(1000);
		objhbpg.setPflname("Lonkar");	Thread.sleep(1000);
		objhbpg.setPfemail("varsha.r.lonkar@gmail.com");	Thread.sleep(1000);
		objhbpg.setPfmobile("7798825022");	Thread.sleep(1000);
		objhbpg.setPfcity("Pune");	Thread.sleep(1000);
		objhbpg.setPfstate("Maharashtra");	Thread.sleep(1000);
		objhbpg.setPfpersons(5);	Thread.sleep(1000);
		objhbpg.setPfcardholder("Varsha Lonkar");	Thread.sleep(1000);
		objhbpg.setPfdebit("4018061238126688");	Thread.sleep(1000);
		objhbpg.setPfcvv("297");	Thread.sleep(1000);
		objhbpg.setPfmonth("5");	Thread.sleep(1000);
		objhbpg.setPfyear("2023"); 
		navigate_to_welcome_page();
		
	}*/
	
	
}
