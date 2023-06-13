package Poms;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TAP {
	WebDriver driver;
	String alertButtonXpath = "//button[text()='Click Me']";
	String filexXpath = "//select[@name='files']";
	String speedXpath= "//select[@name='speed'";

	
	public TAP(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void clickAlertButton() {
		WebElement button = this.driver.findElement(By.xpath(this.alertButtonXpath));
		button.click();
	}

	public void acceptAlert() {
		this.driver.switchTo().alert().accept();
		System.out.println("You pressed OK!");
	}

	public void cancelAlert() {
		this.driver.switchTo().alert().dismiss();
		System.out.println("You pressed Cancel!");
	}

	public String selectCheckBoxByValue(String option) {
		String value = "";
		Select cb = (Select) this.driver.findElement(By.xpath(filexXpath));
		List<WebElement>options=cb.getOptions();
		cb.selectByValue(option);
		return value;
	}
	
	public String selectCheckBoxByText(String option) {
		String value = "";
		Select cb = (Select) this.driver.findElement(By.xpath(speedXpath));
		cb.selectByValue(option);
		return value;
	}
	public String selectCheckBoxByIndex(int option) {
		String value = "";
		Select cb = (Select) this.driver.findElement(By.xpath(speedXpath));
		
		return value;
	}
	

}
