import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class HomePage {
	WebDriver driver;
	String baseUrl="https://demo.opencart.com/";
	
	
	//To check whether product search bar function is working properly or not.
  

  
  @Test(priority=1)
  public void HP_TC_01() {
	  
	  driver.findElement(By.xpath("//a[contains(text(),'Your Store')]")).click();
  }
  @Test(priority=2)
  public void HP_TC_02() {
	  driver.navigate().to(baseUrl);
	  Actions a=new Actions(driver);
	  a.clickAndHold(driver.findElement(By.linkText("Desktops"))).perform();
	  driver.findElement(By.linkText("PC (0)")).click();
	  driver.findElement(By.xpath("//a[contains(text(),'Continue')]")).click();
  }
  @Test(priority=3)
  public void HP_TC_03() {
	  driver.navigate().to(baseUrl);
	  driver.findElement(By.xpath("//body/div[@id='common-home']/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/img[1]")).isDisplayed();
	  String img=driver.findElement(By.xpath("//body/div[@id='common-home']/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/img[1]")).getAttribute("alt");
	  System.out.println(img);
	  if(driver.findElement(By.cssSelector("div.container:nth-child(4) div.row div.col-sm-12 div.swiper-viewport:nth-child(1) div.swiper-pager > div.swiper-button-next")).isDisplayed()) {
	  driver.findElement(By.cssSelector("div.container:nth-child(4) div.row div.col-sm-12 div.swiper-viewport:nth-child(1) div.swiper-pager > div.swiper-button-next")).click();
	  }
	  
  }
  @Test(priority=4)
  public void HP_TC_04() {
	  WebElement div= driver.findElement(By.xpath("//body/div[@id='common-home']/div[1]/div[1]/div[2]/div"));
	  System.out.println(div.getSize());  
  }
  @Test(priority=5)
  public void HP_TC_05() {
	  String div1=driver.findElement(By.xpath("//body/div[@id='common-home']/div[1]/div[1]/div[3]/div[1]/div[1]/div[6]")).getAttribute("class");
	  System.out.println(div1);
	  String img1=driver.findElement(By.xpath("//body/div[@id='common-home']/div[1]/div[1]/div[3]/div[1]/div[1]/div[6]/img[1]")).getAttribute("src");
	  System.out.println(img1);
	  
  }
  //To setUp the connection with driver for automation
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
