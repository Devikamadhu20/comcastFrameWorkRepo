package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JavaUtility {
	
	public int getRandomNumber() {
		Random random=new Random();
		int randomNumber = random.nextInt(10000);
		return randomNumber;
	}
	
	public String getSystemDateYYYYMMDD() {
		Date dateobj=new Date();
		SimpleDateFormat sof=new SimpleDateFormat("yyyy-MM-dd");
		String date = sof.format(dateobj);
		return date;
	}
	
	public String getRequiredDateYYYYDDMM(int days) {
		Date dateobj=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String date = sim.format(dateobj);
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String reqDate = sim.format(cal.getTime());
		return reqDate;
	}
	
	public void validateIfContains(String text,String partialtext){
		if(text.contains(partialtext))
	       {
	    	   System.out.println(partialtext +" is created successfully======PASS");
	       }
	       else
	       {
	    	   System.out.println(partialtext +"is not created =====FAIL");
	       }
	}
	
	public void validateIfEquals(String str1,String str2){
		if(str1.trim().contains(str2))
	       {
	    	   System.out.println(str1 +" information is verified ======PASS");
	       }
	       else
	       {
	    	   System.out.println(str1 +" verification failed =====FAIL");
	       }
	}
	
     
	
	

}
