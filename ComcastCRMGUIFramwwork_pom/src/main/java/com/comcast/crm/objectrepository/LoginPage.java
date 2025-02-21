package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class LoginPage {
	
	

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "user_name")
	private WebElement usernameedt;

	@FindBy(name = "user_password")
	private WebElement passwordedt;

	@FindBy(id = "submitButton")
	private WebElement loginBtn;

	public WebElement getUsernameedt() {
		return usernameedt;
	}

	public WebElement getPasswordedt() {
		return passwordedt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public void loginToapp(String username, String Password) { 
		
		
		usernameedt.sendKeys(username);
		passwordedt.sendKeys(Password);
		loginBtn.click();
	}

}
