package practice.testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ParallelExecutionWithoutSuiteXml {
	@Test(invocationCount = 3, threadPoolSize = 3)
	public void createInvoiceTest() {
	       WebDriver driver=new ChromeDriver();	
	       driver.get("http://flipkart.com");
		}

}
