
package com.comcast.crm.orgtest;

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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.listenerUtility.ListImpClass;
import com.comcast.crm.objectrepository.CreateNewOrganizationPage;
import com.comcast.crm.objectrepository.HomePage;
import com.comcast.crm.objectrepository.LoginPage;
import com.comcast.crm.objectrepository.OrganizationInfoPage;
import com.comcast.crm.objectrepository.OrganizationPage;
@Listeners(com.comcast.crm.listenerUtility.ListImpClass.class)
public class CreateOrganisationTest extends BaseClass {

	@Test(groups = "smokeTest")
	public void createOrganisationTest() throws Throwable {

		// Step 1:read the data from excel
		UtilityClassObject.getTest().log(Status.INFO, "read the data from excel");
		String Orgname = eLib.getDataFromExcel("org", 1, 2) + jLib.getRandomNumber();
       
		// Step 2:navigate to organization module
		UtilityClassObject.getTest().log(Status.INFO, "navigate to organization module");
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// step 3: click on "create organization" Button
		UtilityClassObject.getTest().log(Status.INFO, "create organization Button");
		OrganizationPage cnp = new OrganizationPage(driver);
		cnp.getCreateNewOrgBtn().click();

		// step 4:enter all the details and create new organization
		UtilityClassObject.getTest().log(Status.INFO, "create new organization");
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.getOrgNameEdt().sendKeys(Orgname);
		cnop.getSaveBtn().click();

		//
		OrganizationInfoPage oif = new OrganizationInfoPage(driver);
		String headerInfo = oif.getHeaderTextInfoRead().getText();
		String actorgname = oif.getOrganizationNameRead().getText();
		boolean status=headerInfo.contains(Orgname);
		Assert.assertTrue(status);
		//jLib.validateIfContains(headerInfo, Orgname);
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(actorgname, Orgname);
		//jLib.validateIfEquals(actorgname, Orgname);
	}

	@Test(groups = "regressionTest")
	public void createOrgWithIndustries() throws Throwable {
		String Orgname = eLib.getDataFromExcel("org", 4, 2) + jLib.getRandomNumber();
		String industry = eLib.getDataFromExcel("org", 4, 3);
		String type = eLib.getDataFromExcel("org", 4, 4);

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateNewOrgBtn().click();

		// to select the dropdown
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createNewOrgWithIndustryAndtype(Orgname, industry, type);

		// verify industry
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String acIndustries = oip.getIndustryRead().getText();
		jLib.validateIfEquals(acIndustries, industry);

		// verify type
		String actType = oip.getTypeRead().getText();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(actType, type);
		//jLib.validateIfEquals(actType, type);
	}

	@Test(groups = "regressionTest")
	public void createOrgWithPhoneNumber() throws Throwable {
		String Orgname = eLib.getDataFromExcel("org", 7, 2) + jLib.getRandomNumber();
		String phonenumber = eLib.getDataFromExcel("org", 7, 3);

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateNewOrgBtn().click();

		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.getOrgNameEdt().sendKeys(Orgname);
		cnop.getphoneNoEdit().sendKeys(phonenumber);
		cnop.getSaveBtn().click();

		// verify the phone number info
		OrganizationInfoPage oif = new OrganizationInfoPage(driver);
		String actPhoneNum = oif.getphoneNoRead().getText();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(actPhoneNum, phonenumber);
		//jLib.validateIfEquals(actPhoneNum, phonenumber);

	}

}
