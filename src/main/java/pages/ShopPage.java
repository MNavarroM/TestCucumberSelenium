package pages;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;



public class ShopPage extends Base{
	
	@FindBy(className = "app_logo")
	private WebElement logo;
	@FindBy(xpath = "//img[@class='inventory_item_img']")
	private List<WebElement> photoItem;
	@FindBy(id = "react-burger-menu-btn")
	private WebElement btnBurger;
	@FindBy(xpath = "//*[@class='bm-item menu-item']")
	private List<WebElement> btnMenu;
	@FindBy(className = "btn_inventory")
	private List<WebElement> addButtons;
	@FindBy(xpath = "//option[1]")
	private WebElement sorter;
	@FindBy(className = "footer_copy")
	private WebElement footer;
	
	   Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		       .withTimeout(Duration.ofSeconds(5L))
		       .pollingEvery(Duration.ofSeconds(1L))
		       .ignoring(NoSuchElementException.class);
	
	public ShopPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	
	public String getUrlPhotoItem(int item) {
		
		return photoItem.get(item).getAttribute("src");
	}
	
	public String getLogoName() {
		return getText(logo);
	}
	
	public String getButtonItemText(int item) {
		return addButtons.get(item).getText();
	}
	
	public int getNumItems() {
		return addButtons.size();
	}


	public void clickItem() {
		photoItem.get(0).click();		
	}
	
	public void clickAddToCart(int item) {
		addButtons.get(item).click();		
	}
	
	public List<WebElement> getListaMenu() {
		click(btnBurger);
		return new WebDriverWait(driver, Duration.ofSeconds(3))
		        .until(ExpectedConditions.visibilityOfAllElements(btnMenu));
	}
	
	
	public String getTextSorter() {
		return getText(sorter);
	}
	
	public String getTextFooter() {
		return getText(footer);
	}
	
	public void close() {
		this.driver.quit();
	}
	
	
	
}
