import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class Search {
	WebDriver driver;
	String baseUrl="https://demo.opencart.com/";
	
	//Search for an available product
	@Test
	public void S_TC_01() {
		driver.findElement(By.xpath("//header/div[1]/div[1]/div[2]/div[1]/input[1]")).sendKeys("iMac");
		driver.findElement(By.xpath("//header/div[1]/div[1]/div[2]/div[1]/span[1]/button[1]")).click();
		System.out.println(driver.findElement(By.tagName("h2")).getText());
		System.out.println(driver.findElement(By.tagName("p")).getText());
		
	}
	//Search for an unavailable product
	@Test
	public void S_TC_02() {
		driver.navigate().to(baseUrl);
		driver.findElement(By.xpath("//header/div[1]/div[1]/div[2]/div[1]/input[1]")).sendKeys("fitbit");
		driver.findElement(By.xpath("//header/div[1]/div[1]/div[2]/div[1]/span[1]/button[1]")).click();
		System.out.println(driver.findElement(By.tagName("h2")).getText());
		System.out.println(driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/p[2]")).getText());
		
	}
	@BeforeTest
	public void beforetest() {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.get(baseUrl);
		  driver.manage().window().maximize();
	}
	@AfterTest
	public void aftertest() {
		driver.close();
		System.out.println("Thank you.....");
	}
}
