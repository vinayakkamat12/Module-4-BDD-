package com.cg.newbddapp.pagebean;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPageBean {

    WebDriver driver;
	
	//step 1 : identify elements
	@FindBy(name="userName")
	@CacheLookup
	WebElement pfuname;

	//using how class
	@FindBy(how=How.NAME, using="userPwd")
	@CacheLookup
	WebElement pfpwd;

	@FindBy(className="btn")
	@CacheLookup
	WebElement pflogin;
	
	//initiating the elements
	public LoginPageBean(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//setters
			public void setPfuname(String suname) {
				pfuname.sendKeys(suname);
			}
			
			public void setPfpwd(String spwd) {
				pfpwd.sendKeys(spwd);
			}
			public void setPflogin() {
				pflogin.click();
			}

			public WebElement getPfuname() {
				return pfuname;
			}

			public WebElement getPfpwd() {
				return pfpwd;
			}
			
			
}
