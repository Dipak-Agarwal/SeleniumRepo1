package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver ldriver) {
		this.driver = ldriver;
	}

	@FindBy(id = "txtUsername")
	WebElement username;

	@FindBy(id = "txtPassword")
	WebElement password;

	@FindBy(id = "btnLogin")
	WebElement loginButton;

	public void verifyLoginPanel() {
		Assert.assertTrue(loginButton.isDisplayed());
	}

	public void loginToHRM(String user, String pass) {
		username.sendKeys(user);
		password.sendKeys(pass);
		loginButton.click();
	}

}
