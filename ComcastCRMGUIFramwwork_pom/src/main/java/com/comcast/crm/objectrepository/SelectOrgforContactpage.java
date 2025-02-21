package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectOrgforContactpage {
	public SelectOrgforContactpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="search_text")
	private WebElement searchTextEdit;
	
	@FindBy(name="search")
	private WebElement searchButton;

	public WebElement getSearchTextEdit() {
		return searchTextEdit;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

}
