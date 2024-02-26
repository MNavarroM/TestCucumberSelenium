package StepDefinition.login;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.ShopPage;

public class StepsLogin {

	private WebDriver driver;
	private LoginPage loginPage;
	private ShopPage shopPage;
	
	
	public StepsLogin() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\navar\\eclipse-workspace\\SeleniumPageObject\\test-selenium-page-factory\\src\\main\\resources\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
		loginPage = new LoginPage(driver);
	}
	
	@Given("^The user on login page$")
	public void the_user_enter_on_login_page()throws Throwable {
		loginPage.visit("https://www.saucedemo.com");
	}
	
	@When("^The user enter the valid credentials$")
	public void the_user_enter_the_valid_credentials() throws Throwable {
		loginPage.writeUserAndPassword("standard_user","secret_sauce");
		loginPage.clickLoginButton();
		System.out.println("b");
	}
	
	@Then("^The user was redirected to the home page$")
	public void the_user_was_redirected_to_the_home_page() throws Throwable {
		shopPage = new ShopPage(driver);
		Assert.assertEquals(shopPage.getLogoName(), "Swag Labs");
		System.out.println("c");
		driver.quit();
	}
	
	@When("^The user enter the incorrect credentials$")
	public void the_user_enter_the_incorrect_credentials() throws Throwable {
		System.out.println("1");
		System.out.println("2");
		loginPage.writeUserAndPassword("standard_user","se");
		loginPage.clickLoginButton();

	}
	
	@Then("^The login page show a error message$")
	public void the_login_page_show_a_error_message() throws Throwable {
		System.out.println("3");
		loginPage.loginError("user","user");			
		Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service");
		driver.quit();
		
	}

	@When("^The user enter the blocked credentials$")
	public void the_user_enter_the_blocked_credentials() throws Throwable {
		loginPage.visit("https://www.saucedemo.com");
		loginPage.loginError("locked_out_user","secret_sauce");			
		loginPage.clickLoginButton();

	}
	
	@Then("^The login page show a error block message$")
	public void the_login_page_show_a_error_block_message() throws Throwable {
		System.out.println("3");
		Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Sorry, this user has been locked out."
				+ "");		
		driver.quit();
		
	}

	
}
