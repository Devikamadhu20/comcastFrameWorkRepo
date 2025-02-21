package com.comcast.crm.contacttest;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepository.ContactInfoPage;
import com.comcast.crm.objectrepository.ContactsPage;
import com.comcast.crm.objectrepository.CreateNewContactPage;
import com.comcast.crm.objectrepository.CreateNewOrganizationPage;
import com.comcast.crm.objectrepository.HomePage;
import com.comcast.crm.objectrepository.LoginPage;
import com.comcast.crm.objectrepository.OrganizationInfoPage;
import com.comcast.crm.objectrepository.OrganizationPage;
import com.comcast.crm.objectrepository.SelectOrgforContactpage;

public class CreateContactTest extends BaseClass {

	@Test(groups = {"smokeTest","regressionTest"})
	public void createContactTest() throws Throwable {

		// read testScript data from Excel File
		String lastName = eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandomNumber();

		// Navigate to contacts module
		HomePage hp = new HomePage(driver);
		hp.getContactlnk().click();

		// click on create contact button
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateNewcontactBtn().click();

		// enter all the details and create new contact
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.getLastnameEdit().sendKeys(lastName);
		cncp.getSaveBtn().click();

		// verify lastname in the header of the message
		String actHeader=cp.getHeaderTextInfoRead().getText();
		boolean status=actHeader.contains(lastName);
		Assert.assertEquals(status, true);

		// verify lastname
		String actlastname = cp.getLastNameRead().getText();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(actlastname, lastName);
	}
	
	@Test(groups = "regressionTest")
	public void createContactWithSupportDate() throws Throwable {
		//read testscript data from Excel file
		String lastName=eLib.getDataFromExcel("contact", 4, 2)+jLib.getRandomNumber();
		
		//Navigate to contacts module
		 HomePage hp=new HomePage(driver);
		 hp.getContactlnk().click();
				
	   //click on create contact button
		 ContactsPage cp=new ContactsPage(driver);
		 cp.getCreateNewcontactBtn().click();
				
	  //enter all the details and create new contact
		 CreateNewContactPage cncp =new CreateNewContactPage(driver);
		 		 
		String startDate = jLib.getSystemDateYYYYMMDD();
		String endDate = jLib.getRequiredDateYYYYDDMM(30);
		cncp.createNewContactWithDates(lastName, startDate, endDate);
		
		  //verify startdate 
		ContactInfoPage cip=new ContactInfoPage(driver);
		String actstartdate =cip.getStartDateRead().getText();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(actstartdate, startDate);

		  String actenddate =cip.getEndDateRead().getText();
		  soft.assertEquals(actenddate, endDate);
		  soft.assertAll();
		  
}
	
	@Test(groups = "regressionTest")
	public void createContactWithOrg() throws Throwable {
		//read testscript data from Excel file
		String Orgname=eLib.getDataFromExcel("org", 1, 2)+jLib.getRandomNumber();
        String lastName=eLib.getDataFromExcel("contact", 1, 2)+jLib.getRandomNumber();
        
      //Navigate to org module	
		HomePage hp=new HomePage(driver);
		hp.getOrgLink().click();
        
		//click on create org button
        OrganizationPage op=new OrganizationPage(driver);
        op.getCreateNewOrgBtn().click();
        
        //enter all the details and create new org
        CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
        cnop.getOrgNameEdt().sendKeys(Orgname);
        cnop.getSaveBtn().click();
       
      //verify header orgname info expected result
        OrganizationInfoPage oip=new OrganizationInfoPage(driver);
        String headerInfo = oip.getOrganizationNameRead().getText();
        SoftAssert soft=new SoftAssert();
		soft.assertEquals(headerInfo, Orgname);
        
     	 
       //navigate to contact module
        hp.getContactlnk().click();
        
        //click on create contact button
        ContactsPage cp=new ContactsPage(driver);
        cp.getCreateNewcontactBtn().click();
        
        //enter all the details and create new contact
        CreateNewContactPage cncp=new CreateNewContactPage(driver);
        cncp.getLastnameEdit().sendKeys(lastName);
        cncp.getSelectOrgButton().click();
		
	     //switch to child window	
		wLib.switchToWindowOnURL(driver, "module=Accounts");
		
		SelectOrgforContactpage socp=new SelectOrgforContactpage(driver);
		socp.getSearchTextEdit().sendKeys(Orgname);
		socp.getSearchButton().click();
		
		driver.findElement(By.xpath("//a[text()='"+Orgname+"']")).click();
	
		wLib.switchToWindowOnURL(driver, "module=Contacts");
		cncp.getSaveBtn().click();

		//verify header orgname info expected result
		ContactInfoPage cip=new ContactInfoPage(driver);
        String headerInfo1 = cp.getHeaderTextInfoRead().getText();
        //soft.assertEquals(headerInfo1, lastName);
		boolean status=headerInfo1.contains(lastName);
		Assert.assertEquals(status, true);
        
     
     //verify header message expected result
       String actOrgname = cip.getOrganizationRead().getText();
//       soft.assertEquals(actOrgname, Orgname);
//       soft.assertAll();
       boolean status1=actOrgname.contains(Orgname);
		Assert.assertEquals(status1, true);
	}
	}
		
		
		
		

	
	

