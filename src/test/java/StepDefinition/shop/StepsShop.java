package StepDefinition.shop;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.ShopPage;

public class StepsShop {

	private WebDriver driver;
	private LoginPage loginPage;
	private ShopPage shopPage;
	
	public StepsShop() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\navar\\eclipse-workspace\\SeleniumPageObject\\test-selenium-page-factory\\src\\main\\resources\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
		loginPage = new LoginPage(driver);
		shopPage = new ShopPage(driver);


	}
	
	@Given("^A valid user logged$")
	public void a_valid_user_logged() throws Throwable {
		loginPage.visit("https://www.saucedemo.com");
		loginPage.writeUserAndPassword("standard_user","secret_sauce");
		loginPage.clickLoginButton();
	}

	
	@Then("^The images of product was different$")
	public void the_images_of_product_was_different() throws Throwable {
		String urlPhotoItem1 = shopPage.getUrlPhotoItem(0);
		String urlPhotoItem2 = shopPage.getUrlPhotoItem(1);
		Assert.assertNotEquals(urlPhotoItem1, urlPhotoItem2);
		driver.quit();

	}
	
	@Then("^The left buttons are corrects$")
	public void the_left_buttons_are_corrects() throws Throwable {
		List<WebElement> items = shopPage.getListaMenu();
		Assert.assertEquals(items.get(0).getText(), "All Items");
		Assert.assertEquals(items.get(1).getText(), "About");
		Assert.assertEquals(items.get(2).getText(), "Logout");
		Assert.assertEquals(items.get(3).getText(), "Reset App State");
		driver.quit();

	}
	
	@Then("^The footer text are correct$")
	public void the_footer_text_are_correct() throws Throwable {
		Assert.assertEquals("© 2024 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy", shopPage.getTextFooter());
		driver.quit();

	}
	
	@Then("^Sort by default are A to Z$")
	public void sort_by_default_are_A_to_Z() throws Throwable {
		Assert.assertEquals("Name (A to Z)", shopPage.getTextSorter());
		driver.quit();
	}
	
	 
	@When("^The user click add cart button$")
	public void the_user_click_add_cart_button() throws Throwable {
		Assert.assertEquals("Add to cart", shopPage.getButtonItemText(1));
		shopPage.clickAddToCart(1);
		
	}

	@Then("^The button text change value$")
	public void the_button_text_change_value() throws Throwable {
		Assert.assertEquals("Remove", shopPage.getButtonItemText(1));
		driver.quit();
	}
}
