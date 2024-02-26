package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class LoginPage extends Base{
	
	@FindBy(id = "user-name")
	private WebElement username;
	@FindBy(id = "password")
	private WebElement password;
	@FindBy(id = "login-button")
	private WebElement loginButton;
	@FindBy(xpath = "//*[@id=\"login_button_container\"]/div/form/div[3]/h3")
	private WebElement errorMesage;

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void writeUserAndPassword(String username, String password) throws AssertionError {
		try {
			write(username, this.username);
			write(password,this.password);
		} catch (AssertionError e) {
			throw e;
		}
		
	}
	
	public void clickLoginButton() {
		click(loginButton);
	}
	
	public void loginError(String username, String password) throws AssertionError {
		write(username, this.username);
		write(password,this.password);
		click(loginButton);			
	}
	
	public String getErrorMessage() {
		return getText(errorMesage);
	}	
	
}
