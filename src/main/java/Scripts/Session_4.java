package Scripts;

import org.junit.*;
import org.openqa.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Poms.GooglePage;
import Poms.TAP;

public class Session_4 {

	private WebDriver driver;

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
		gp.clickResutyById(0);
		tap.clickAlertButton();
		Thread.sleep(1000);
		tap.acceptAlert();
		
		tap.clickAlertButton();
		Thread.sleep(1000);
		tap.cancelAlert();
		
		String value = tap.selectCheckBoxByValue("3");
		System.out.println(value);

		String value2 = tap.selectCheckBoxByText("Medium");
		System.out.println(value2);
		
		String value3= tap.selectCheckBoxByIndex(1);
		System.out.println(value3);
	}

	@After
	public void teardown() {

		// driver.quit();
	}
}
