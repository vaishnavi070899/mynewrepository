package testcase;
//Add necessary imports
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class store_name_mandatory_check {
	  WebDriver driver;
	  @Test
	  public void test() throws IOException {
		  driver.findElement(By.id("MainNavSignupButton")).click();
		  driver.findElement(By.id("0_signup_email")).sendKeys("vaihnavi.guptm@gmail.com");
		  driver.findElement(By.id("0_signup_password")).sendKeys("123456@abcdef");
		  driver.findElement(By.name("button")).click();
		  TakesScreenshot scrShot =((TakesScreenshot)driver);
		  File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(SrcFile, new File("C:\\Users\\ACER\\Desktop\\selenium space\\miniproject\\test-output\\SrcFile.png"));
		  String errormessage= driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/form/div[3]/div/span/span[2]")).getText();
		  System.out.println("The displayed message is: "+errormessage);
		  
	  }
	  
	  @BeforeMethod
	  public void beforeMethod() {
		// Scanner declaration
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the test browser: ");
		// Scanning the name of the browser
		String drivername = sc.nextLine();
		//select a browser and implement it:
		if (drivername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\ACER\\Desktop\\selenium space\\miniproject\\chrome driver\\chromedriver.exe");
			driver= new ChromeDriver();
			}
		else if (drivername.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\ACER\\Desktop\\selenium space\\miniproject\\chrome driver\\geckodriver.exe");
			driver= new FirefoxDriver();
			}
		else if (drivername.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "C:\\Users\\ACER\\Desktop\\selenium space\\miniproject\\chrome driver\\IEDriverServer.exe");
			driver= new InternetExplorerDriver();
			}
		else if (drivername.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\ACER\\Desktop\\selenium space\\miniproject\\chrome driver\\msedgedriver.exe");
			driver= new EdgeDriver();
			}
		else if (drivername.equalsIgnoreCase("opera")) {
			System.setProperty("webdriver.opera.driver", "C:\\Users\\ACER\\Desktop\\selenium space\\miniproject\\chrome driver\\operadriver.exe");
			driver= new OperaDriver();
			}
		// maximizes the window
		driver.manage().window().maximize();                              
		//Apply Implicit Wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver navigates to the shopify web site
		driver.get("https://www.shopify.in/");							  
	  }

	  @AfterMethod
	  public void afterMethod() {
		// quits the driver
		driver.quit();		  
	  }

}
