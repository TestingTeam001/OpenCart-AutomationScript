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
public class CheckOut {
	WebDriver driver;
	String baseUrl="https://demo.opencart.com/";
	
	//for a new address
	@Test(priority=1)
	public void CO_TC_01()throws InterruptedException {
		Scanner sc=new Scanner(System.in);
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("HP LP");
		driver.findElement(By.xpath("//body[1]/header[1]/div[1]/div[1]/div[2]/div[1]/span[1]/button[1]")).click();
		driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[2]/button[1]")).click();
		driver.findElement(By.id("button-cart")).click();
		System.out.println(driver.findElement(By.xpath("//body[1]/div[2]/div[1]")).getText());
		driver.findElement(By.xpath("//body[1]/nav[1]/div[1]/div[2]/ul[1]/li[4]/a[1]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Checkout')]")).click();
		System.out.println("Enter registered email id");
		String em=sc.next();
		driver.findElement(By.id("input-email")).sendKeys(em);
		System.out.println("Enter password");
		String password=sc.next();
		driver.findElement(By.id("input-password")).sendKeys(password);
		driver.findElement(By.id("button-account")).click();
		driver.findElement(By.id("input-payment-firstname")).sendKeys("Ninjaboy");
		driver.findElement(By.id("input-payment-lastname")).sendKeys("Kalu");
		driver.findElement(By.id("input-payment-address-1")).sendKeys("NalaSupara");
		driver.findElement(By.id("input-payment-city")).sendKeys("Nalbari");
		driver.findElement(By.id("input-payment-postcode")).sendKeys("101010");
		driver.findElement(By.id("input-payment-password")).sendKeys("1234");
		driver.findElement(By.id("input-payment-confirm")).sendKeys("1234");
		driver.findElement(By.name("agree")).click();
		System.out.println("Enter a different email");
		String email=sc.next();
		driver.findElement(By.id("input-payment-email")).sendKeys(email);
		driver.findElement(By.id("input-payment-telephone")).sendKeys("1920392039930");
		Select drpCountry = new Select(driver.findElement(By.name("country_id")));
		drpCountry.selectByVisibleText("India");
		Select drpZone = new Select(driver.findElement(By.name("zone_id")));
		drpZone.selectByVisibleText("Assam");
		driver.findElement(By.id("button-register")).click();
		driver.findElement(By.id("button-shipping-address")).click();
		driver.findElement(By.id("button-payment-address")).click();
		Dimension d = new Dimension(210,400);
		driver.manage().window().setSize(d);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		WebDriverWait wait=new WebDriverWait(driver, 9);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("button-shipping-method")));
		try{driver.findElement(By.id("button-shipping-method")).click();
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.id("button-payment-method")).click();
		driver.findElement(By.id("button-confirm")).click();
		System.out.println(driver.findElement(By.tagName("h1")).getText());
		System.out.println(driver.findElement(By.tagName("p")).getText());
		driver.findElement(By.xpath("//a[contains(text(),'Continue')]")).click();
		
		}catch(StaleElementReferenceException e){
			System.out.println(e.getMessage());}
		
	}
	@BeforeTest
	public void beforetest() {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.get(baseUrl);
		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	@AfterTest
	public void aftertest() {
		driver.close();
		System.out.println("Thank you.....");
	}
}
