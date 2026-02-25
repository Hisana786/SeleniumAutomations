package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@name=\"username\"]")WebElement user;
	@FindBy(xpath = "//input[@name=\"password\"]")WebElement pass;
	@FindBy(xpath = "//button[@type=\"submit\"]")WebElement signinbutton;
	@FindBy(xpath = "//p[text()='Dashboard']")WebElement dashboardtile;
	@FindBy(xpath = "//b[text()='7rmart supermarket']")WebElement logintext;
	@FindBy(xpath = "//b[text()='7rmart supermarket']")WebElement loginstext;
	
	public LoginPage enterUsernameOnUsernameField(String usernamevalue)
	{
		user.sendKeys(usernamevalue);
		return this;
	}
	
	public LoginPage enterPasswordOnPasswordField(String passwordvalue)
	{
		pass.sendKeys(passwordvalue);
		return this;
	}
	
	public HomePage clickOnSignInButton()
	{
		signinbutton.click();
		return new HomePage(driver);
	}
	
	public boolean isDashboardDisplayed() {
		return dashboardtile.isDisplayed();
			 
	 }
	 
	 public String dashboardText() {
		 return logintext.getText();
	 }
}
