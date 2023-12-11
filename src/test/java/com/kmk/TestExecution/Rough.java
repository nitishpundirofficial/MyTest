package com.kmk.TestExecution;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Rough {

		public WebDriver driver;

		String URL = "https://www.cutebabyvote.com/april-2023/?contest=photo-detail&photo_id=231926";
		
		@Test
		public void clickToVote() throws Exception 
		{
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();
			
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			
			
			for(int i=0;i<1000;i++)
			{
				driver.navigate().to(URL);
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollBy(951,3800)", "");
				

				Thread.sleep(3000);
				driver.findElement(By.xpath("//div[contains(text(),'CLICK TO VOTE')]")).click();
				String voteCount = driver.findElement(By.xpath("//div[@class='pc-votes-count']")).getText();
				System.out.println("Updated vote count is "+voteCount);
				Thread.sleep(1810000);
			
			}
			
			
		}
}




