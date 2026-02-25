package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	
	public WebDriver driver;
	public ManageNewsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add']")WebElement newbutton;
	@FindBy(xpath="//textarea[@id='news']")WebElement news;
	@FindBy(xpath="//button[@type='submit']")WebElement save;
	
	@FindBy(xpath="//a[@href='javascript:void(0)']")WebElement searchbutton;
	@FindBy(xpath="//input[@type='text']")WebElement text;
	@FindBy(xpath="//button[@type='submit']")WebElement search;
	
	@FindBy(xpath="//i[@class='ace-icon fa fa-sync-alt']")WebElement reset;
	@FindBy(xpath="//li[text()='Manage News']")WebElement managenewstext;

	
	public ManageNewsPage clickOnNewButton()
	{
		newbutton.click();
		return this;
	}
	
	public ManageNewsPage enterNewsOnNewsField(String newsformat)
	{
		news.sendKeys(newsformat);
		return this;
	}
	
	public ManageNewsPage clickOnSaveButton()
	{
		save.click();
		return this;
	}
	
	public ManageNewsPage clickOnSearchButton()
	{
		searchbutton.click();
		return this;
	}
	
	public ManageNewsPage enterNewsonSearchField(String newsformat)
	{
		text.sendKeys(newsformat);
		return this;
	}
	
	public ManageNewsPage clickOnSubmitButton()
	{
		search.click();
		return this;
	}
	
	public ManageNewsPage cickOnResetButton()
	{
		reset.click();
		return this;
	}
	
	public boolean isManageNewsDisplayed()
	{
		return managenewstext.isDisplayed();
	}
}
