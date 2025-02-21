package miscilleneous.concepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class redBusSelectDate {
	
	@Test
	public void selectDate() {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//i[@class='sc-cSHVUG NyvQv icon icon-datev2']")).click();
		driver.findElement(By.xpath("//span[text()='18']")).click();
		driver.findElement(By.xpath("//i[@class='sc-cSHVUG NyvQv icon icon-datev2']")).click();
	    driver.findElement(By.id("Layer_1")).click();
	    driver.findElement(By.xpath("//span[text()='20']")).click();
	}
	
	@Test
	public void selectDate_irctc() {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//span[@class='ng-tns-c57-8 ui-autocomplete ui-widget']/input")).sendKeys("BAngalore",Keys.ENTER);
		//driver.findElement(By.xpath("//p-autocomplete[@id='destination']")).sendKeys("Delhi",Keys.ENTER);
		driver.findElement(By.xpath("//p-calendar[@id='jDate']")).click();
		driver.findElement(By.xpath("//a[text()='20']")).click();
		driver.findElement(By.xpath("//p-calendar[@id='jDate']")).click();
	    driver.findElement(By.xpath("//span[@class='ui-datepicker-next-icon pi pi-chevron-right ng-tns-c58-10']")).click();
	    driver.findElement(By.xpath("//a[text()='20']")).click();
	}
	
	@Test
	public void makeMyTrip_selectDate() {
		String monthDate="March 2025";
		int date=20;
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();
		
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		driver.findElement(By.xpath("//div[text()='"+monthDate+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']")).click();
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		 WebElement nextmonth = driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']"));
		 while(true) {
			 try {
				 driver.findElement(By.xpath("//div[text()='August 2025']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='20']")).click();
				 break;
			 }catch (Exception e) {
				 nextmonth.click();
			 }
			 }
		 }
		 
		 @Test
			public void airIndia_selectDate() {
//				String monthDate="March 2025";
//				int date=20;
				WebDriver driver=new ChromeDriver();
				driver.get("https://www.airindia.com/");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.findElement(By.id("onetrust-accept-btn-handler")).click();
				driver.findElement(By.xpath("//input[@id='dpFromDate']")).click(); 
				driver.findElement(By.xpath("//div[text()=' March 2025 '] /ancestor::div[@class='ngb-dp-month']/descendant::div[text()=' 20 ']")).click();
				driver.findElement(By.xpath("//div[text()=' March 2025 '] /ancestor::div[@class='ngb-dp-month']/descendant::div[text()=' 24 ']")).click();
		 
	}
		 
		 @Test
			public void goibibo_selectDate() {
//				String monthDate="March 2025";
//				int date=20;
				WebDriver driver=new ChromeDriver();
				driver.get("https://www.goibibo.com/");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
				driver.findElement(By.xpath("//p[@class='sc-12foipm-4 czGBLf fswWidgetTitle']")).click();
	            driver.findElement(By.xpath("//div[text()='February 2025']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='20']")).click();
	            driver.findElement(By.xpath("//p[text()='Round-trip']/../span[@class='sc-12foipm-70 bWWMhV']")).click();
	            
	}
		 
	}


