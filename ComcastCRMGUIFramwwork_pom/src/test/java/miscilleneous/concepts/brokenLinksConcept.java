package miscilleneous.concepts;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class brokenLinksConcept {
	@Test
	public void brokenLink() {
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		System.out.println(links.size());
		
		for( WebElement eachlink:links) {
			String link = eachlink.getDomAttribute("href");
			
			try {
				URL url = new URL(link);
				HttpURLConnection httpcon=(HttpURLConnection)url.openConnection();
				int statuscode=httpcon.getResponseCode();
				if(statuscode>=400) {
					System.out.println(link+" ----> "+statuscode);
				}
				
				
			}catch (Exception e) {
				
			}
		}
	
		
	}
	
	@Test
	public void demoApps() {
			WebDriver driver=new ChromeDriver();
			driver.get("https://www.passportindia.gov.in/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			List<WebElement> links = driver.findElements(By.xpath("//a"));
			System.out.println(links.size());
			
			for( WebElement eachlink:links) {
				String link = eachlink.getDomAttribute("href");
				
				try {
					URL url = new URL(link);
					HttpURLConnection httpcon=(HttpURLConnection)url.openConnection();
					int statuscode=httpcon.getResponseCode();
					if(statuscode>=400) {
						System.out.println(link+" ----> "+statuscode);
					}	
				}catch (Exception e) {
					
				}
			  }
	       }
	}



