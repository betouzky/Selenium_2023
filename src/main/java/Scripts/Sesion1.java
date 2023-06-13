package Scripts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Poms.GooglePage;

public class Sesion1 {
	
	private WebDriver driver;
	
	@Before
	public void setUp() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		driver = new ChromeDriver(options);	}
	
	@Test
	public void test() throws InterruptedException {
		driver.get("https:/www.google.com");
		GooglePage gp = new GooglePage(driver);
		Thread.sleep(2000);
		//busqueda en google
		gp.typeOnSearchBar("Robot Wikipedia");
		Thread.sleep(3000);
		gp.clickFirstresult("//*[@id=\"rso\"]/div[1]/div/div/div[1]/div/a/h3");
		gp.printFirstResult("//*[@id=\"mw-content-text\"]/div[1]/p[1]");
	}
	
	//funcion que imprima el primer texto en la pagina de wiki
	//sobre nintendo wikipedia  es getText
	//
	//
	@After
	public void teardown() {
		
		//driver.quit();
	}
	public Sesion1() {
		// TODO Auto-generated constructor stub
	}

}
