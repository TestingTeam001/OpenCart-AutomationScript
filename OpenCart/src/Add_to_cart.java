import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class Add_to_cart {
	WebDriver driver;
	String baseUrl="https://demo.opencart.com/";
	//To check whether we can add any product
	@Test
	public void CA_TC_01_02_03_07() {
		driver.findElement(By.xpath("//header/div[1]/div[1]/div[2]/div[1]/input[1]")).sendKeys("iMac");
		driver.findElement(By.xpath("//header/div[1]/div[1]/div[2]/div[1]/span[1]/button[1]")).click();
		driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[2]/button[1]")).click();
		System.out.println(driver.findElement(By.xpath("//body[1]/div[2]/div[1]")).getText());
		driver.findElement(By.xpath("//body[1]/nav[1]/div[1]/div[2]/ul[1]/li[4]/a[1]/i[1]")).click();
		driver.findElement(By.linkText("Continue Shopping")).click();
	}
	@Test
	public void CA_TC_04() {
		driver.findElement(By.xpath("//header/div[1]/div[1]/div[2]/div[1]/input[1]")).sendKeys("Apple Cinema 30\"");
		driver.findElement(By.xpath("//header/div[1]/div[1]/div[2]/div[1]/span[1]/button[1]")).click();
		driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[2]/button[1]")).click();
		System.out.println(driver.findElement(By.xpath("//body[1]/div[2]/div[1]")).getText());
		driver.findElement(By.xpath("//body[1]/nav[1]/div[1]/div[2]/ul[1]/li[4]/a[1]/i[1]")).click();
		driver.navigate().to(baseUrl);
	}
	@Test
	public void CA_TC_05() {
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.linkText("Desktops"))).build().perform();
		driver.findElement(By.linkText("Show All Desktops")).click();
		driver.findElement(By.linkText("Mac (1)")).click();
		System.out.println(driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/h4[1]/a[1]")).getText());
		driver.findElement(By.xpath("//body[1]/header[1]/div[1]/div[1]/div[3]/div[1]/button[1]")).click();
		driver.findElement(By.xpath("//body[1]/header[1]/div[1]/div[1]/div[3]/div[1]/ul[1]/li[2]/div[1]/p[1]/a[1]")).click();
		driver.findElement(By.linkText("Continue Shopping")).click();
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
