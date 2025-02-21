package com.comcast.crm.basetest;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepository.HomePage;
import com.comcast.crm.objectrepository.LoginPage;

public class BaseClass {
	public WebDriver driver;
	public DataBaseUtility dbLib=new DataBaseUtility();
	public FileUtility fLib=new FileUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public JavaUtility jLib=new JavaUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	public static WebDriver sdriver=null;
	
	
	@BeforeSuite(groups= {"smokeTest","regressionTest"})
	public void congigBS() throws SQLException {
		System.out.println("=====Connect to DB, Report Congig=====");
		dbLib.getDbConnection();
	}

	@Parameters("BROWSER")
	@BeforeClass(groups= {"smokeTest","regressionTest"})
	public void congigBC(String browser) throws Throwable {
		System.out.println("=====Launch the BROWSER=====");
		String BROWSER= browser;
				//fLib.getDataFromPropertiesFile("browser");
		String URL = fLib.getDataFromPropertiesFile("url");
		if(BROWSER.equals("chrome")){
			driver=new ChromeDriver();
		}else if(BROWSER.equals("firefox")){
			driver=new FirefoxDriver();
		}else if(BROWSER.equals("edge")){
			driver=new EdgeDriver();
		}else {
			driver=new ChromeDriver();
		}
		sdriver=driver;
		UtilityClassObject.setDriver(driver);
		
		driver.get(URL);
		wLib.maximizeWindow(driver);
		wLib.waitForPageToLoad(driver);
		
	}
	
	@BeforeMethod(groups= {"smokeTest","regressionTest"})
	public void congigBM() throws Throwable {
		System.out.println("=====login=====");
		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.loginToapp( USERNAME, PASSWORD);
	}
	
	@AfterMethod(groups= {"smokeTest","regressionTest"})
	public void congigAM() {
		System.out.println("=====logout=====");
		HomePage hp=new HomePage(driver);
		hp.SignoutAction(driver);
	}
	
	@AfterClass(groups= {"smokeTest","regressionTest"})
	public void congigAC() {
		System.out.println("=====Close the BROWSER=====");
	   driver.quit();
	}
	
	@AfterSuite(groups= {"smokeTest","regressionTest"})
	public void congigAS() {
		System.out.println("=====Close DB, Report backUp=====");
		dbLib.closeDbConnection();
	}
	
	
	
	
	
}
