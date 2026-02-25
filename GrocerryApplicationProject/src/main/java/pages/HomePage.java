package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class HomePage {
public WebDriver driver;
	
	WaitUtility wait = new WaitUtility();
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
		
@FindBy(xpath="//img[@src='https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/avatar5.png']")WebElement adminlogoutbuttonicon;
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']")WebElement logout;
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']")WebElement managenews;
@FindBy(xpath="//a[@class='small-box-footer']")WebElement manageadmin;
@FindBy(xpath ="//p[text()='Dashboard']")WebElement dashboardtile;
@FindBy(xpath ="//b[text()='7rmart supermarket']")WebElement logintext;

public HomePage clickOnAdminLogoutButton() {
	adminlogoutbuttonicon.click();
	return this;
	}
public LoginPage clicOnLogoutButton()
{
	wait.waitUntilElementToBeClickable(driver, logout);
	logout.click();
	return new LoginPage(driver);
	}
public ManageNewsPage clickOnManageNews()
{
	managenews.click();
	return new ManageNewsPage(driver);
}
public ManageAdminPage clickOnManageAdmin()
{
	manageadmin.click();
	return new ManageAdminPage(driver);
}

public boolean isDashboardDisplayed() {
	return dashboardtile.isDisplayed();
		 
 }
 
 public String dashboardText() {
	 return logintext.getText();
 }

}
