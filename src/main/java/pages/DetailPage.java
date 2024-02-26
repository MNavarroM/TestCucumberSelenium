package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class DetailPage extends Base{

	private WebDriver driver;
	
	@FindBy(className = "inventory_details_img")
	private WebElement imgItem;

	public DetailPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	
	public String getUrlImage() {
		return getAttribute("src", imgItem);		
	}

	public boolean checkPageUrl() {
		return driver.getCurrentUrl().equals("https://ejemplo.com/login");
	}

	
}
