package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest_JUnit {
	private static final TimeUnit SECONDS = null;
	WebDriver driver;
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("Before Class");	
	}
	@AfterClass
	public static void afterClass() {
		System.out.println("After Class");
	}
	//@After
	public void tearDown() {
		driver.close();	
	}
	@Before
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\nesar\\July_2022\\crm\\driver\\chromedriver.exe");
		//	System.setProperty("webdriver.chrome.driver" , "driver\chromedriver.exe");
			driver = new ChromeDriver();
			// Clear Cashe
			driver.manage().deleteAllCookies();
			driver.get("https://techfios.com/billing/?ng=admin/");
			driver.manage().timeouts().implicitlyWait(5, SECONDS);
			driver.manage().window().maximize();
	}
	@Test
	public void LoginTest() {
		System.out.println("Login Test");
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();	
	}
	@Test
	public void negLoginTest() {
		System.out.println("After Class");
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc1234");
		driver.findElement(By.name("login")).click();	
	}	
}



