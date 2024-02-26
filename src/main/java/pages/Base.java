package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	protected WebDriver driver;
	
	public Base(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver chromeDriverConnection() {
		System.setProperty("webdriver.Chrome", "C:\\Users\\navar\\eclipse-workspace\\SeleniumPageObject\\test-selenium-page-factory\\src\\main\\resources\\chromedriver");
		driver = new ChromeDriver();
		return driver;
	}
	
	public WebElement findElement(WebElement element) {
		return findElement(element);
	}
	
	public List<WebElement> findElements(WebElement element) {
		return findElements(element);
	}	
	
	public String getText(WebElement element) {
		return element.getText();
	}
		
	public String getAttribute(String attribute, WebElement element) {
		return element.getAttribute(attribute);
	}
	
	public String getUrl() {
		return driver.getCurrentUrl();
	}
	
	public void write(String text, WebElement element) {
		element.sendKeys(text);
	}
	
	public void click(WebElement element) {
		element.click();
	}
	
	public Boolean isDisplayed(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
		
	}
	
	public void visit(String url) {
		driver.get(url);
	}

}
