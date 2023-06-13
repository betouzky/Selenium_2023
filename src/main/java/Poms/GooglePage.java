package Poms;
import org.openqa.selenium.JavascriptExecutor;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GooglePage {

	WebDriver driver;
	String searchBarId = "APjFqb";
	String firstresult = "//*[@id=\"rso\"]/div[1]/div/div/div[1]/div/a/h3";
	String resultsClass = "//h3[@class='LC20lb MBeuO DKV0Md']";

	public GooglePage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public GooglePage() {

	}

	public void typeOnSearchBar(String value) {
		WebElement searchBar = driver.findElement(By.id(searchBarId));
		searchBar.sendKeys(value);
		searchBar.sendKeys(Keys.ENTER);
	}

	public void clickFirstresult(String primero) {
		// TODO Auto-generated method stub
		WebElement fr = driver.findElement(By.xpath(primero));
		fr.click();
	}

	public void printFirstResult(String Element) {
		WebElement fr = driver.findElement(By.xpath(Element));
		System.out.println(fr.getText());
	}

	public void clickResutyById(int result) {
		List<WebElement> list = driver.findElements(By.xpath(resultsClass));
		// System.out.println(list.size());
		list.get(result).click();
	}

	public void printTitle() {
		System.out.println(driver.getTitle());
	}

	public void printResults() {
		List<WebElement> list = driver.findElements(By.xpath(resultsClass));
		for (WebElement element : list) {
			System.out.println(element.getText());
		}
	}
	
	public void abrirNuevaPestana(WebDriver driver, String url) {
        // Abrir una nueva pestaña en el navegador y cambiar al nuevo controlador
		  JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.open('" + url + "', '_blank');");
        
    }
	 public void cambiarAVentana(WebDriver driver, int indice) {
	        String[] handles = driver.getWindowHandles().toArray(new String[0]);
	        driver.switchTo().window(handles[indice]);
	    }
	 
	 public void cambiarAVentanaNombre(WebDriver driver, String nombreVentana) {
		    String ventanaActual = driver.getWindowHandle();
		    for (String ventana : driver.getWindowHandles()) {
		        driver.switchTo().window(ventana);
		        if (driver.getTitle().equals(nombreVentana)) {
		            return;
		        }
		    }
		    // Si no se encuentra la ventana con el nombre especificado, volver a la ventana original
		    driver.switchTo().window(ventanaActual);
		}

}
