package steps;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks extends BaseClass{

	@Before
	public void beforeScenario(Scenario sc) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver=new ChromeDriver(options);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		driver.manage().window().maximize();
		//driver.get("https://www.nykaa.com/");
//		driver.get("https://www.ajio.com/");
//		Thread.sleep(2000);
		driver.get("https://www.pepperfry.com/");
		
		
		
	}
//	
//	@After
//	public void afterScenario(Scenario sc) {
//		// TODO Auto-generated method stub
//		driver.quit();
//	}
}
