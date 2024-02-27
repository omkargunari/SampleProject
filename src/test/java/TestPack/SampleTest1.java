package TestPack;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SampleTest1{

	public String baseUrl = "http://localhost:4200/login";  
	//String driverPath = "C://chromedriver_win321//chromedriver.exe";  
	public WebDriver driver ; 
	
	
	@BeforeTest  
	public void beforeTest() {
		System.out.println("before test");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");

		options.addArguments("--disable-extensions");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--dns-prefetch-disable");
		options.setExperimentalOption("useAutomationExtension", false);

		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//driver.get(baseUrl);

	}
	
	
	//@Test             
	public void registrationTest() {

		driver.get(baseUrl);

		// get the current URL of the page
		String URL = driver.getCurrentUrl();
		System.out.print(URL);
		// get the title of the page
		String title = driver.getTitle();
		System.out.println(title);
		try {
			Thread.sleep(2000);

			driver.findElement(By.xpath("//a[@href='/register']")).click(); // clicking on register

			driver.findElement(By.id("firstname")).sendKeys("Rajkumar");

			driver.findElement(By.id("lastname")).sendKeys("Kunta");

			driver.findElement(By.id("username")).sendKeys("Rajkumar");

			driver.findElement(By.id("password")).sendKeys("Rajkumar");

			driver.findElement(By.xpath("//*/button[contains(text(),'Register')]")).click();

			String actualString = driver.findElement(By.xpath("/html/body/app/div[1]/div/div/div/alert/div")).getText();
			String expectedString = "Registration successful";

			Assert.assertEquals(actualString, expectedString);

			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void LoginTest() {
		
		try {
			Thread.sleep(1000);
		driver.get(baseUrl);
		
		String userName="rajkumar";
		String password="rajkumar";
		
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		Thread.sleep(2000);
		/*driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("password")).clear();
		
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);*/
		driver.findElement(By.xpath("//*/button[contains(text(),'Login')]")).click();
		//String assertMessage= driver.findElement(By.xpath("/html/body/app/div[1]/div/div/div/ng-component/h1")).getText();
		//Assert.assertTrue(assertMessage.contains("Hi"));
		
		
			
			Thread.sleep(60000);
			
		}catch(Exception e) {
			
		}
		
			
	}
	
	     
	
	
	
	@AfterTest  
	public void afterTest() {  
	driver.quit();  
	System.out.println("after test");  
	}   
}
	
	

