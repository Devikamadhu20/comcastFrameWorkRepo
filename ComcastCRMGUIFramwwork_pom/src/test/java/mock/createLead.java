package mock;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepository.ContactsPage;
import com.comcast.crm.objectrepository.CreateNewContactPage;
import com.comcast.crm.objectrepository.CreateNewLeadPage;
import com.comcast.crm.objectrepository.HomePage;
import com.comcast.crm.objectrepository.calendarIconPage;
import com.comcast.crm.objectrepository.convertLeadPage;
import com.comcast.crm.objectrepository.convertToLeadPage;

public class createLead extends BaseClass {
	@Test
	public void createlead() throws Throwable {
		// read the last name from excel file
		String leadName = eLib.getDataFromExcel("lead", 1, 2) + jLib.getRandomNumber();
		String companyName = eLib.getDataFromExcel("lead", 1, 3) + jLib.getRandomNumber();

		// Navigate to contacts module
		HomePage hp = new HomePage(driver);
		hp.getLeadLink().click();

		// click on create contact button
		ContactsPage cp = new ContactsPage(driver);
		cp.getLeadNameRead().click();

		// enter all the details and create new contact
		CreateNewLeadPage cnlp = new CreateNewLeadPage(driver);
		cnlp.getLastnameEdit().sendKeys(leadName);
		cnlp.getCompanynameEdit().sendKeys(companyName);
		cnlp.getSaveBtnEdit().click();
		Thread.sleep(1000);
		
		//click on convert to lead link
		convertToLeadPage ctlp=new convertToLeadPage(driver);
		wLib.mousemoveOnElementAndClick(driver, ctlp.getConToLeadLink());
		
		//click on opportunity button
		convertLeadPage clp=new convertLeadPage(driver);
		clp.getOpportunityBtn().click();
		
		//click on calendar icon
		calendarIconPage cip=new calendarIconPage(driver);
		cip.getCalendarClick().click();
		Thread.sleep(1000);
		
		//select next month
		
		cip.getDate().click();
		

	}

}
