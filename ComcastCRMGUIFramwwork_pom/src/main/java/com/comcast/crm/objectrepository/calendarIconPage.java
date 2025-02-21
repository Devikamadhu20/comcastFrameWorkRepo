package com.comcast.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class calendarIconPage {
	
	public calendarIconPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="jscal_trigger_closedate")
	private WebElement calendarClick;
	
	@FindBy(xpath = "//td[@class='hilite nav button hilite']")
	private WebElement nextmonth;
	
	@FindBy(xpath = "//td[text()='24']")
	private WebElement date;
	
	public WebElement getDate() {
		return date;
	}

	@FindBy(xpath="//td[@class='hilite nav button hilite']/following-sibling::td[@text()='19']")
    private WebElement dateIdentify;
	
	public WebElement getDateIdentify() {
		return dateIdentify;
	}

	public WebElement getNextmonth() {
		return nextmonth;
	}

	public WebElement getCalendarClick() {
		return calendarClick;
	}

}
