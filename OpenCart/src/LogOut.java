import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class LogOut{
	WebDriver driver;
	String baseUrl="https://demo.opencart.com/";
	@Test
	public void LO_TC_01() {
		driver.findElement(By.xpath("//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]/a[1]/i[1]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
		driver.findElement(By.id("input-email")).sendKeys("gmail@mail.com");
		driver.findElement(By.id("input-password")).sendKeys("Mail@2002");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.findElement(By.xpath("//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]/a[1]")).click();
		driver.findElement(By.linkText("Logout")).click();
		String logouth1tag=driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/h1[1]")).getText();
		System.out.println(logouth1tag);
		String logoutptag=driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/p[1]")).getText();
		System.out.println(logoutptag);
		driver.findElement(By.xpath("//a[contains(text(),'Continue')]")).click();
		driver.navigate().back();
		driver.navigate().back();//To check whether there is a glitch of login and logout.
		driver.navigate().refresh();
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
