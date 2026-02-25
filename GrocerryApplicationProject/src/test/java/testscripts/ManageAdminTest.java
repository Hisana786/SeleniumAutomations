package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.TestNGBase;
import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageAdminPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class ManageAdminTest extends TestNGBase{
	HomePage home;
	ManageAdminPage admin;
	@Test
	public void verifyUserisAbletoAddAdminUsers() throws IOException
	{
		String usernamevalue = ExcelUtility.getStringData(0, 0,"LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1,"LoginPage");
		
		LoginPage logins = new LoginPage(driver);
		logins.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		home = logins.clickOnSignInButton();
		
		//HomePage home = new HomePage(driver);
		admin = home.clickOnManageAdmin();
		
		ManageAdminPage admin = new ManageAdminPage(driver);
		admin.clickOnNewButton();
		
		FakerUtility faker = new FakerUtility();
		String username = faker.createRandomUsername();
		String password = faker.createRandomPassword();
		
		admin.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).selectUsertypeFromUsertypeField().clickOnSaveButton();
		
		boolean adminusersdisplay = admin.isAdminUserTextDisplayed();
		Assert.assertTrue(adminusersdisplay,Constants.CREATEADMINERROR );
	}
	
	@Test
	public void verifyUserisAbleSearchtheAddedAdminUsers() throws IOException
	{
		String usernamevalue = ExcelUtility.getStringData(0, 0,"LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1,"LoginPage");
		String username = ExcelUtility.getStringData(1, 0,"ManageAdminPage");
		
		LoginPage logins = new LoginPage(driver);
		logins.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		home = logins.clickOnSignInButton();
		
		//HomePage home = new HomePage(driver);
		admin = home.clickOnManageAdmin();
		
		//ManageAdminPage admin = new ManageAdminPage(driver);
		admin.clickOnSearchButton().enterUsernameOnSearchField(username).selectUsertypeFromSearchField().clickOnSearch();
		
		boolean adminusersdisplay = admin.isAdminUserTextDisplayed();
		Assert.assertTrue(adminusersdisplay, Constants.SEARCHADMINERROR );
	}
	
	@Test
	public void verifyUserisAbletoResettheAdminUsers() throws IOException
	{
		String usernamevalue = ExcelUtility.getStringData(0, 0,"LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1,"LoginPage");
		
		LoginPage logins = new LoginPage(driver);
		logins.enterUsernameOnUsernameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		home = logins.clickOnSignInButton();
		
		//HomePage home = new HomePage(driver);
		admin = home.clickOnManageAdmin();
		
		//ManageAdminPage admin = new ManageAdminPage(driver);
		admin.clickOnResetButton();
		
		boolean adminusersdisplay = admin.isAdminUserTextDisplayed();
		Assert.assertTrue(adminusersdisplay,Constants.RESETADMINERROR );
	}
}

