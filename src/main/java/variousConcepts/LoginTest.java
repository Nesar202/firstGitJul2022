package variousConcepts;

import org.apache.commons.exec.launcher.CommandLauncher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
	static WebDriver driver;
	public static void main(String[] args) {
		launchBrowser();
		LoginTest();
		tearDown();
		
		launchBrowser();
		negLoginTest();
		tearDown();	
	}
	public static void LoginTest() {
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();	
	}
	public static void negLoginTest() {
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc1234");
		driver.findElement(By.name("login")).click();
		
	}
	public static void launchBrowser() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\nesar\\July_2022\\crm\\driver\\chromedriver.exe");
		//	System.setProperty("webdriver.chrome.driver" , "driver\chromedriver.exe");
			driver = new ChromeDriver();
			// Clear Cashe
			driver.manage().deleteAllCookies();
			driver.get("https://techfios.com/billing/?ng=admin/");
			driver.manage().window().maximize();
		
	}
	public static void tearDown() {
		driver.close();	
	}
}
