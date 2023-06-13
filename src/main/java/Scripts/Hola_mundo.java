package Scripts;
import Poms.GooglePage;
import Poms.TAP;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class Hola_mundo {

	private WebDriver driver;
	//String searchBarXpath = "//*[@name='q']";
	
	@Before
	public void setUp() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		driver = new ChromeDriver(options);	}
	
	@Test
	public void test() throws InterruptedException {
		GooglePage gp = new GooglePage(driver);
		TAP tap = new TAP(driver);
		driver.get("https:/www.google.com");
		Thread.sleep(2000);
		
		gp.typeOnSearchBar("test automation practice");
		Thread.sleep(2000);
		gp.clickResutyById(1);
		tap.clickAlertButton();
		Thread.sleep(1000);
		tap.acceptAlert();
		
		tap.clickAlertButton();
		Thread.sleep(1000);
		tap.cancelAlert();
		
	}
	
	@After
	public void teardown() {
		//driver.quit();
	}

}
