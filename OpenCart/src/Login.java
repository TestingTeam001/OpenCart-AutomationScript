import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class Login {
	WebDriver driver;
	String baseUrl="https://demo.opencart.com/";
	
	//Login using valid credentials
	@Test
	public void LI_TC_01() {
		driver.findElement(By.xpath("//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]/a[1]/i[1]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
		driver.findElement(By.id("input-email")).sendKeys("gmail@mail.com");
		driver.findElement(By.id("input-password")).sendKeys("Mail@2002");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}
	//Login using invalid credentials
	@Test
	public void LI_TC_02() {
		driver.findElement(By.xpath("//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]/a[1]")).click();
		driver.findElement(By.linkText("Logout")).click();
		driver.findElement(By.xpath("//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]/a[1]/i[1]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
		driver.findElement(By.id("input-email")).sendKeys("gmail@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Mail123");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String alert=driver.findElement(By.xpath("//body/div[@id='account-login']/div[1]")).getText();
		System.out.println(alert);
	}
	//Login checking forgotten password function
	@Test
	public void LI_TC_03() {
		
		driver.findElement(By.linkText("Forgotten Password")).click();
		driver.findElement(By.id("input-email")).sendKeys("gmail@mail.com");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		String confirm=driver.findElement(By.xpath("//body/div[@id='account-login']/div[1]")).getText();
		Assert.assertTrue(confirm.contains("Login Successfully"));
	}
	@BeforeTest
	  public void beforeClass() {
		  System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.get(baseUrl);
		  driver.manage().window().maximize();
	  }
	@AfterTest
	public void afterclass() {
		driver.close();
		System.out.println("Thank you.....");
	}
	
}
