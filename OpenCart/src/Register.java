import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

import java.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class Register {
	WebDriver driver;
	String baseUrl="https://demo.opencart.com/";
	
	//Register with valid input
	@Test
	public void R_TC_01() {
		Scanner sc=new Scanner(System.in);
		driver.findElement(By.cssSelector(".dropdown .hidden-xs")).click();
		driver.findElement(By.linkText("Register")).click();
		System.out.println("Enter your first name");
		String first=sc.next();
		driver.findElement(By.id("input-firstname")).sendKeys(first);
		System.out.println("Enter your last name");
		String last=sc.next();
		driver.findElement(By.id("input-lastname")).sendKeys(last);
		System.out.println("Enter your phone number");
		String ph=sc.next();
		driver.findElement(By.id("input-telephone")).sendKeys(ph);
		System.out.println("Enter your email");
		String email=sc.next();
		driver.findElement(By.id("input-email")).sendKeys(email);
		System.out.println("Enter a password");
		String ps=sc.next();
		driver.findElement(By.id("input-password")).sendKeys(ps);
		System.out.println("Confirm your password");
		String cps=sc.next();
		driver.findElement(By.id("input-confirm")).sendKeys(cps);
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.cssSelector(".btn-primary")).click();
		driver.findElement(By.linkText("Continue")).click();
		driver.findElement(By.xpath("//span[contains(text(),'My Account')]")).click();
		driver.findElement(By.cssSelector("div.container div.nav.pull-right ul.list-inline li.dropdown.open:nth-child(2) ul.dropdown-menu.dropdown-menu-right li:nth-child(5) > a:nth-child(1)")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Continue')]")).click();
	}
	//Register is displayed or not
	@Test
	public void R_TC_02() {
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]")).click();
        driver.findElement(By.linkText("Register")).click();
        if(driver.findElement(By.xpath("//*[@id=\"account-register\"]/div[1]")).isDisplayed()) {
        	System.out.println("Register is displayed");
        }
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
	}
}
