package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.TestNGBase;
import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends TestNGBase{
	HomePage home;
	ManageNewsPage manage;
	@Test
	public void verifyUserisAbletoAddNewNews() throws IOException
	{
		String usernamevalue = ExcelUtility.getStringData(0, 0,"LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1,"LoginPage");
		String newsformat = ExcelUtility.getStringData(0, 0,"ManageNewsPage");
		
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		home = login.clickOnSignInButton();
		
		//HomePage home = new HomePage(driver);
		manage = home.clickOnManageNews();
		
		//ManageNewsPage manage = new ManageNewsPage(driver);
		manage.clickOnNewButton().enterNewsOnNewsField(newsformat).clickOnSaveButton();
		
		boolean managenewsdisplay = manage.isManageNewsDisplayed();
		Assert.assertTrue(managenewsdisplay, Constants.ADDNEWSERROR);
	}
	@Test
	public void verifyUserisAbletoSearchtheAddedNews() throws IOException
	{
		String usernamevalue = ExcelUtility.getStringData(0, 0,"LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1,"LoginPage");
		String newsformat = ExcelUtility.getStringData(0, 0,"ManageNewsPage");
		
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		home = login.clickOnSignInButton();
		
		//HomePage home = new HomePage(driver);
		manage = home.clickOnManageNews();
		
		//ManageNewsPage manage = new ManageNewsPage(driver);
		manage.clickOnSearchButton().enterNewsonSearchField(newsformat).clickOnSubmitButton();
		
		boolean managenewsdisplay = manage.isManageNewsDisplayed();
		Assert.assertTrue(managenewsdisplay, Constants.SEARCHNEWSERROR );
	}
	@Test
	public void verifyWhetherUserisAbletoResettheNews() throws IOException
	{
		String usernamevalue = ExcelUtility.getStringData(0, 0,"LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1,"LoginPage");
		
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		home = login.clickOnSignInButton();
		
		//HomePage home = new HomePage(driver);
		manage = home.clickOnManageNews();
		
		//ManageNewsPage manage = new ManageNewsPage(driver);
		manage.cickOnResetButton();
		
		boolean managenewsdisplay = manage.isManageNewsDisplayed();
		Assert.assertTrue(managenewsdisplay, Constants.RESETNEWSERROR );
	}

}

