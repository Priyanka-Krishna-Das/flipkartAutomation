package com.baseClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public static WebDriver driver;
	
	
	@BeforeClass
	@Parameters("browser") //name of the parameter
	public void broserLaunch(String br)
	{
		if(br.equals("chrome"))
		{
			driver= new ChromeDriver();
			System.out.println("chromeDriver");
		}
		else if(br.equals("edge"))
		{
			driver= new EdgeDriver();
		
		}
		else
		{
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.get("https://www.flipkart.com/");
		
	}
	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	
	

}
