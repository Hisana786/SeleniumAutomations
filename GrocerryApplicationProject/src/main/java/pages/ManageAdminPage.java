package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utilities.PageUtility;

public class ManageAdminPage {
	
PageUtility page = new PageUtility();
	
	public WebDriver driver;
	public ManageAdminPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath="//a[@href='javascript:void(0)']")WebElement newButton;
	@FindBy(xpath="//input[@id='username']")WebElement user;
	@FindBy(xpath="//input[@id='password']")WebElement pass;
	@FindBy(xpath="//select[@id='user_type']")WebElement usertype;
	@FindBy(xpath="//button[@name='Create']")WebElement savebutton;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")WebElement searchButton;
	@FindBy(xpath="//input[@type='text']")WebElement users;
	@FindBy(xpath="//select[@id='ut']")WebElement usertypes;
	@FindBy(xpath="//button[@type='submit']")WebElement search;
	
	@FindBy(xpath="//i[@class='ace-icon fa fa-sync-alt']")WebElement reset;
	@FindBy(xpath="//h1[@class='m-0 text-dark' and text()='Admin Users']")WebElement adminUserText;
	
	public ManageAdminPage clickOnNewButton()
	{
		newButton.click();
		return this;
	}
	
	public ManageAdminPage enterUsernameOnUsernameField(String username)
	{
		user.sendKeys(username);
		return this;
	}
	
	public ManageAdminPage enterPasswordOnPasswordField(String password)
	{
		pass.sendKeys(password);
		return this;
	}
	
	public ManageAdminPage selectUsertypeFromUsertypeField()
	{
		page.selectDropdownWithVisibleText(usertype, Constants.DROPDOWNVALUE);
		return this;
		//Select select = new Select(usertype);
		//select.selectByVisibleText("Staff");
	}
	
	public ManageAdminPage clickOnSaveButton()
	{
		savebutton.click();
		return this;
	}
	
	public ManageAdminPage clickOnSearchButton()
	{
		searchButton.click();
		return this;
	}
	
	public ManageAdminPage enterUsernameOnSearchField(String username)
	{
		users.sendKeys(username);
		return this;
	}
	
	public ManageAdminPage selectUsertypeFromSearchField()
	{
		page.selectDropdownWithVisibleText(usertypes, Constants.DROPDOWNVALUE);
		return this;
		//Select selects = new Select(usertypes);
		//selects.selectByVisibleText("Staff");
	}
	
	public ManageAdminPage clickOnSearch()
	{
		search.click();
		return this;
	}
	
	public ManageAdminPage clickOnResetButton()
	{
		reset.click();
		return this;
	}
	
	public boolean isAdminUserTextDisplayed()
	{
		return adminUserText.isDisplayed();
	}
}
