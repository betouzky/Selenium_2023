package Scripts;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

import Poms.GooglePage;
import Poms.TAP;

public class Sesion5 {
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
		GooglePage gp = new GooglePage(driver);
		TAP tap = new TAP(driver);
		driver.get("https://www.google.com");
		Thread.sleep(2000);
		gp.typeOnSearchBar("Amazon");
		Thread.sleep(2000);
		gp.clickResutyById(0);

		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys("celulares");
		searchBox.submit();
		Thread.sleep(2000);
		WebElement samsungCheckbox = driver.findElement(By.xpath("//span[text()='SAMSUNG']"));
		//*[@id="p_89/SAMSUNG"]/span/a/div/label/i
		samsungCheckbox.click();
		Thread.sleep(2000);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		List<WebElement> results = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']"));

		// Inicializar el precio mínimo como un número grande para comparar
		double minPrice = Double.MAX_VALUE;
		WebElement cheapestCellPhone = null;

		// Iterar sobre los resultados y encontrar el celular más barato
		for (WebElement result : results) {
			WebElement priceElement = result.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/div/div/div/div[2]/div[3]/div/a/span/span[2]/span[2]"));
			//*[@id="search"]/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/div/div/div/div[2]/div[3]/div/a/span/span[2]/span[2]
			String priceText = priceElement.getText().replace(",", "");
			double price = Double.parseDouble(priceText);

			if (price < minPrice) {
				minPrice = price;
				cheapestCellPhone = result;
			}
		}

		// Imprimir el precio del celular más barato
		if (cheapestCellPhone != null) {
			WebElement titleElement = cheapestCellPhone.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/div/div/div/div[2]/div[1]/h2/a/span"));
			String title = titleElement.getText();

			System.out.println("Celular más barato: " + title);
			System.out.println("Precio: $" + minPrice);
		} else {
			System.out.println("No se encontraron resultados.");
		}
	}

	@After
	public void teardow() {

	}

}
