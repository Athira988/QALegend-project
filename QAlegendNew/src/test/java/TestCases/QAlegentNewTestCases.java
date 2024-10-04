
package TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import AutomationCore.BaseClass;

import PageClasses.QAlegendLoginPageNew;
import PageClasses.QAlegendRolePageNew;
import PageClasses.QAlegendSellingPriceGroupPageNew;
import PageClasses.QAlegendVariationsPageNew;
import PageClasses.QAlegentBrandsPageNew;
import PageClasses.QAlegentCustomersPageNew;
import PageClasses.QAlegentHomePageNew;

import PageClasses.QAlegentUsersPageNew;
import Utilities.ExcelUtility;
import Utilities.WaitUtility;
import Utilities.fakerUtility;


public class QAlegentNewTestCases extends BaseClass {
	WebDriver driver;
	QAlegendLoginPageNew loginpage;
	QAlegentHomePageNew homepage;
	QAlegentUsersPageNew userspage;
	QAlegendRolePageNew rolepage;
	QAlegentCustomersPageNew cutomerpage;
	QAlegendVariationsPageNew varitationspage;
	QAlegendSellingPriceGroupPageNew sellingpricegroup;
	QAlegentBrandsPageNew brandpage;
	Properties props;
	FileReader reader;	 
	
	@BeforeMethod (groups= {"smoketest","regression"})
	@Parameters({"Browser"})
	public void initilization(String browser) throws Exception
	{
		props =new Properties();
		reader=new FileReader(System.getProperty("user.dir")+ "\\src\\main\\java\\Resources\\TestData.properties");
		props.load(reader);
		driver= browserInitilization(browser);
		driver.get(props.getProperty("url"));// fetching these details from property file
		driver.manage().window().maximize();
		loginpage=new QAlegendLoginPageNew(driver);
		homepage=new QAlegentHomePageNew(driver);
		userspage=new QAlegentUsersPageNew(driver);
		rolepage=new QAlegendRolePageNew(driver);
		cutomerpage=new QAlegentCustomersPageNew(driver);
		varitationspage=new QAlegendVariationsPageNew(driver);
		sellingpricegroup=new QAlegendSellingPriceGroupPageNew(driver);
		brandpage=new QAlegentBrandsPageNew(driver);			
	}
		
	    @Test
		public void verifyIfUserCanDeleteUser() throws IOException
		{
			loginpage.loginToQAlengend(props.getProperty("username"), props.getProperty("password"));
			homepage.clickOnEndTourButton();
			homepage.clickOnUserMangementOption();
			homepage.clickOnUserAction();
			userspage.clickOnUsersButton();
					
		
		String prefix=ExcelUtility.getString(1, 0, "//src//main//java//Resources//UserDetails.xlsx", "Sheet1")+fakerUtility.randomNumberGenerator();
		String firstname=ExcelUtility.getString(1, 1, "//src//main//java//Resources//UserDetails.xlsx", "Sheet1");
		String lastname=ExcelUtility.getString(1, 2, "//src//main//java//Resources//UserDetails.xlsx", "Sheet1");
		String mail=fakerUtility.randomNumberGenerator()+ExcelUtility.getString(1, 3, "//src//main//java//Resources//UserDetails.xlsx", "Sheet1");	
		String Username=fakerUtility.randomNumberGenerator()+ExcelUtility.getString(1, 4, "//src//main//java//Resources//UserDetails.xlsx", "Sheet1");
		String Password=ExcelUtility.getString(1, 5, "//src//main//java//Resources//UserDetails.xlsx", "Sheet1");
		String ConfirmPassword=ExcelUtility.getString(1, 6, "//src//main//java//Resources//UserDetails.xlsx", "Sheet1");
		String SalesCommissionPercentage=ExcelUtility.getString(1, 7, "//src//main//java//Resources//UserDetails.xlsx", "Sheet1");
		userspage.insertUserDetails(prefix,firstname,lastname,mail,Username,Password,ConfirmPassword,SalesCommissionPercentage);
		userspage.clicksaveButton();	
		String role=props.getProperty("role");
		userspage.enterTextToSearch(role);
		userspage.deleteButton();
		userspage.okButton();		
		Assert.assertEquals(userspage.noMatchingRecordsFound(), "No matching records found");
}
	    @Test
		public void verifyIfUserCanAddRole()
		{
			loginpage.loginToQAlengend(props.getProperty("username"), props.getProperty("password"));
			homepage.clickOnEndTourButton();
			homepage.clickOnUserMangementOption();
			homepage.clickOnRoleAction();
			rolepage.clickOnAddButton();			
			String rolename=props.getProperty("addrole")+fakerUtility.randomNumberGenerator();
			rolepage.enterTextToadd(rolename);
			rolepage.clickOnSaveButton();			
			rolepage.enterroleTextToSearch(rolename);
			Assert.assertEquals(rolepage.getaddedRole(),rolename);
		}
			
	    @Test
		public void verifyIfUserCanEditRole() throws Exception {
			
			loginpage.loginToQAlengend(props.getProperty("username"), props.getProperty("password"));
			homepage.clickOnEndTourButton();
			homepage.clickOnUserMangementOption();
			homepage.clickOnRoleAction();
			rolepage.clickOnAddButton();			
			String rolnumtoedit=props.getProperty("editRole")+fakerUtility.randomNumberGenerator();
			rolepage.enterTextToadd(rolnumtoedit);
			rolepage.clickOnSaveButton();
			rolepage.enterroleTextToSearch(rolnumtoedit);				
			rolepage.clickOnEditButton();
			rolepage.clickOnroleEditCheckBox();
			rolepage.clickOnUpdateButton();
			rolepage.enterroleTextToSearch(rolnumtoedit);				
			rolepage.clickOnEditButton();
		    Assert.assertTrue(rolepage.checkEditedRole()); 
			
		}
		 @Test
		public void verifyIfUserCanDeleteRole() throws InterruptedException
		{
			loginpage.loginToQAlengend(props.getProperty("username"), props.getProperty("password"));
			homepage.clickOnEndTourButton();
			homepage.clickOnUserMangementOption();
			homepage.clickOnRoleAction();
			rolepage.clickOnAddButton();			
			String rolnumtodelete=props.getProperty("addroletodelete")+fakerUtility.randomNumberGenerator();
			rolepage.enterTextToadd(rolnumtodelete);
			rolepage.clickOnSaveButton();
			rolepage.enterroleTextToSearch(rolnumtodelete);			
			rolepage.clickOnDeleteButton();
			rolepage.clickOnOkButton();
			rolepage.enterroleTextToSearch(rolnumtodelete);
			Assert.assertEquals(rolepage.checktheValidationDelete(), "No matching records found");
			
			
		}
		
	    @Test
		public void verifyIfUserCanViewTheCutomerDetails()
		{
			loginpage.loginToQAlengend(props.getProperty("username"), props.getProperty("password"));
			homepage.clickOnEndTourButton();
			homepage.clickOnContactsAction();
			homepage.clickOnCustomersAction();	
			cutomerpage.clickOnActions();
			cutomerpage.clickOnViewOption();
			Assert.assertEquals(cutomerpage.checkCustomerinfo(), "Customer info");
			
		}
		
	    @Test
		public void verifyIfUserCanAddTheVariations() throws InterruptedException
		{
			loginpage.loginToQAlengend(props.getProperty("username"), props.getProperty("password"));
			homepage.clickOnEndTourButton();
			homepage.clickOnProductsAction();
			varitationspage.clickOnVariationsOption();
			varitationspage.clickOnAddVariationButton();			
			String variationname=props.getProperty("variationname")+fakerUtility.randomNumberGenerator();
			varitationspage.enterVariationName(variationname);
			String variationvalue=props.getProperty("addvariationvalues")+fakerUtility.randomNumberGenerator();
			varitationspage.enterVariationvalue(variationvalue);
			varitationspage.enterSaveButton();			
		    varitationspage.enterSearchvalue(variationname);
			Assert.assertEquals(varitationspage.checkaddedVariations(), variationname);
		}
		
	  
	 @Test 
		public void verifyIfUserCanAddSellingPrice()
		{
			loginpage.loginToQAlengend(props.getProperty("username"), props.getProperty("password"));
			homepage.clickOnEndTourButton();
			homepage.clickOnProductsAction();
			homepage.clickOnSellingPriceGroup();
			sellingpricegroup.clickOnAddButton();			
			String sellingpricename=props.getProperty("sellingpricename")+fakerUtility.randomNumberGenerator();
			String sellingpricedesc=props.getProperty("sellingpricedesc")+fakerUtility.randomNumberGenerator();
			sellingpricegroup.enterOnSellingPriceName(sellingpricename);
			sellingpricegroup.enterOnSellingPriceDesc(sellingpricedesc);
			sellingpricegroup.clickOnSaveButton();
			sellingpricegroup.enterSearchText(sellingpricename);
			Assert.assertEquals(sellingpricegroup.elementtoVerify(), sellingpricename); 
		}
	 
	 @Test
	 public void verifyIfUserCanaddBrands() throws Exception
	 {
		 loginpage.loginToQAlengend(props.getProperty("username"), props.getProperty("password"));
			homepage.clickOnEndTourButton();
			homepage.clickOnProductsAction();
			homepage.clickOnBrandName();
			brandpage.clickOnAddButton();			
			String addnametextbox=props.getProperty("addnametextbox")+fakerUtility.randomNumberGenerator();
			String adddescriptiontextbox=props.getProperty("adddescriptiontextbox")+fakerUtility.randomNumberGenerator();
			brandpage.enterNameTextBox(addnametextbox);
			brandpage.enterDescriptionTextBox(adddescriptiontextbox);
			brandpage.clickOnSaveButton();			
			brandpage.enterTextToSearch(adddescriptiontextbox);		
			Assert.assertEquals(brandpage.brandToBeVerified(), addnametextbox); 
			 }
	 @Test
	 public void verifyIfUserCanDeleteBrands() throws Exception
	 {
		 loginpage.loginToQAlengend(props.getProperty("username"), props.getProperty("password"));
			homepage.clickOnEndTourButton();
			homepage.clickOnProductsAction();
			homepage.clickOnBrandName();
			brandpage.clickOnAddButton();			
			String addnametodelete=props.getProperty("addnametodelete")+fakerUtility.randomNumberGenerator();
			String adddescriptiontodelete=props.getProperty("adddescriptiontodelete")+fakerUtility.randomNumberGenerator();
			brandpage.enterNameTextBox(addnametodelete);
			brandpage.enterDescriptionTextBox(adddescriptiontodelete);
			brandpage.clickOnSaveButton();
			brandpage.enterTextToSearch(adddescriptiontodelete);			
			brandpage.clickOnDeleteButton();  
			brandpage.clickOnOkButton();			
			Assert.assertEquals(brandpage.validationMessageVerificationOnDelete(), "No matching records found");
			
	 }
}
