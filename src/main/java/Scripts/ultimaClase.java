package Scripts;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import Poms.GooglePage;
import Poms.TAP;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ultimaClase {
	WebDriver driver;

	@Before
	public void setUp() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		driver = new ChromeDriver(options);
	}

	@Test
	public void test() throws InterruptedException {
		Scanner scanner = new Scanner(System.in);
		driver.get("https:/www.google.com");
		GooglePage gp = new GooglePage(driver);
		Thread.sleep(3000);
		// Busqueda en google
		gp.typeOnSearchBar("Wikipedia");
		Thread.sleep(1000);
		gp.clickResutyById(0);
		Thread.sleep(1000);
		gp.abrirNuevaPestana(driver, "https://www.google.com/");
		gp.cambiarAVentana(driver, 1);
		gp.typeOnSearchBar("youtube");
		Thread.sleep(1000);
		gp.clickResutyById(0);
		Thread.sleep(1000);
		gp.abrirNuevaPestana(driver, "https://www.google.com/");
		gp.cambiarAVentana(driver, 2);
		gp.typeOnSearchBar("automation practice");
		Thread.sleep(1000);
		gp.clickResutyById(3);
		Thread.sleep(1000);
		gp.abrirNuevaPestana(driver, "https://www.google.com/");
		gp.cambiarAVentana(driver, 3);
		gp.typeOnSearchBar("amazon");
		Thread.sleep(1000);
		gp.clickResutyById(0);
		Thread.sleep(1000);
		gp.abrirNuevaPestana(driver, "https://www.google.com/");
		gp.cambiarAVentana(driver, 4);
		gp.typeOnSearchBar("mercado libre");
		Thread.sleep(1000);
		gp.clickResutyById(0);
		Thread.sleep(1000);
		String eleccion;
		do {
			
			System.out.println("a que pestaña deseas ir?");
			eleccion=scanner.nextLine();
			gp.cambiarAVentanaNombre(driver, eleccion);
			System.out.println("deseas seguir cambiando?");
			System.out.println("si=1      no=0");
			int salida= scanner.nextInt();
			scanner.nextLine();
			if(salida==0)
				break;
		}while(true);
		
		
		
	}

	// gp.clickFirstresult();
	@After
	public void teardow() {

	}

}
