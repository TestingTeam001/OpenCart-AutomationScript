import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class AddToWishList {
	WebDriver driver;
	String baseUrl="https://demo.opencart.com/";
	@Test
	public void ATW_TC_01() {
	    driver.findElement(By.name("search")).sendKeys("hp lp");
	    driver.findElement(By.name("search")).click();
	    driver.findElement(By.cssSelector("button > .fa-heart")).click();
	    driver.findElement(By.linkText("wish list")).click();
	  }
	@Test
	  public void ATW_TC_02() {
	    driver.navigate().to(baseUrl);
	    driver.findElement(By.xpath("//body[1]/nav[1]/div[1]/div[2]/ul[1]/li[3]/a[1]/i[1]")).click();
	    driver.findElement(By.id("input-email")).sendKeys("soul@you.com");
	    driver.findElement(By.id("input-password")).sendKeys("1234");
	    driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/input[1]")).click();
	  }

	@BeforeTest
	public void beforetest() {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.get(baseUrl);
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	@AfterTest
	public void aftertest() {
		driver.close();
		System.out.println("Thank you.....");
	}

}
