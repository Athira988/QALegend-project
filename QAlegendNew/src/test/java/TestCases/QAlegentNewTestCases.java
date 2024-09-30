
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
		public void deleteUser() throws IOException
		{
			loginpage.loginToQAlengend(props.getProperty("username"), props.getProperty("password"));
			homepage.clickOnEndTourButton();
			homepage.clickOnUserMangementOption();
			homepage.clickOnUserAction();
			userspage.clickOnUsersButton();
			
			
		Random rand= new Random();
		int randomnumber= rand.nextInt(10000);

		String prefix=ExcelUtility.getString(1, 0, "//src//main//java//Resources//UserDetails.xlsx", "Sheet1")+randomnumber;
		String firstname=ExcelUtility.getString(1, 1, "//src//main//java//Resources//UserDetails.xlsx", "Sheet1");
		String lastname=ExcelUtility.getString(1, 2, "//src//main//java//Resources//UserDetails.xlsx", "Sheet1");
		String mail=randomnumber+ExcelUtility.getString(1, 3, "//src//main//java//Resources//UserDetails.xlsx", "Sheet1");	
		String Username=randomnumber+ExcelUtility.getString(1, 4, "//src//main//java//Resources//UserDetails.xlsx", "Sheet1");
		String Password=ExcelUtility.getString(1, 5, "//src//main//java//Resources//UserDetails.xlsx", "Sheet1");
		String ConfirmPassword=ExcelUtility.getString(1, 6, "//src//main//java//Resources//UserDetails.xlsx", "Sheet1");
		String SalesCommissionPercentage=ExcelUtility.getString(1, 7, "//src//main//java//Resources//UserDetails.xlsx", "Sheet1");
		userspage.insertUserDetails(prefix,firstname,lastname,mail,Username,Password,ConfirmPassword,SalesCommissionPercentage);
		userspage.clicksaveButton();	
		String role=props.getProperty("role");
		userspage.enterTextToSearch(role);
		userspage.deleteButton();
		userspage.okButton();		
		AssertJUnit.assertEquals(userspage.noMatchingRecordsFound(), "No matching records found");
}
	    @Test
		public void addRole()
		{
			loginpage.loginToQAlengend(props.getProperty("username"), props.getProperty("password"));
			homepage.clickOnEndTourButton();
			homepage.clickOnUserMangementOption();
			homepage.clickOnRoleAction();
			rolepage.clickOnAddButton();
			Random rand= new Random();
			int randomnumber= rand.nextInt(10000);
			String rolename=props.getProperty("addrole")+randomnumber;
			rolepage.enterTextToadd(rolename);
			rolepage.clickOnSaveButton();			
			rolepage.enterroleTextToSearch(rolename);
			Assert.assertEquals(rolepage.getaddedRole(),rolename);
		}
			
	    @Test
		public void editRole() throws Exception {
			
			loginpage.loginToQAlengend(props.getProperty("username"), props.getProperty("password"));
			homepage.clickOnEndTourButton();
			homepage.clickOnUserMangementOption();
			homepage.clickOnRoleAction();
			rolepage.clickOnAddButton();
			Random rand= new Random();
			int randomnumber= rand.nextInt(10000);
			String rolnumtoedit=props.getProperty("editRole")+randomnumber;
			rolepage.enterTextToadd(rolnumtoedit);
			rolepage.clickOnSaveButton();
			rolepage.enterroleTextToSearch(rolnumtoedit);	
			Thread.sleep(20000);
			rolepage.clickOnEditButton();
			rolepage.clickOnroleEditCheckBox();
			rolepage.clickOnUpdateButton();
			rolepage.enterroleTextToSearch(rolnumtoedit);			 
		    Assert.assertTrue(rolepage.checkEditedRole()); 
			
		}
		 @Test
		public void deleteRole()
		{
			loginpage.loginToQAlengend(props.getProperty("username"), props.getProperty("password"));
			homepage.clickOnEndTourButton();
			homepage.clickOnUserMangementOption();
			homepage.clickOnRoleAction();
			rolepage.clickOnAddButton();
			Random rand= new Random();
			int randomnumber= rand.nextInt(10000);
			String rolnumtodelete=props.getProperty("addroletodelete")+randomnumber;
			rolepage.enterTextToadd(rolnumtodelete);
			rolepage.clickOnSaveButton();
			rolepage.enterroleTextToSearch(rolnumtodelete);
			WebElement deletebutton= driver.findElement(By.xpath ("(//tr[@class='odd']//child::button)[1]")); 
			JavascriptExecutor executer= (JavascriptExecutor)driver;
			executer.executeScript("arguments[0]", deletebutton);
			deletebutton.click();
			rolepage.clickOnOkButton();
			rolepage.enterroleTextToSearch(rolnumtodelete);
			Assert.assertEquals(rolepage.checktheValidationDelete(), "No matching records found");
			
			
		}
		
	    @Test
		public void viewCustomers()
		{
			loginpage.loginToQAlengend(props.getProperty("username"), props.getProperty("password"));
			homepage.clickOnEndTourButton();
			homepage.clickOnContactsAction();
			homepage.clickOnCustomersAction();			
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(cutomerpage.actiondropdown));
			cutomerpage.clickOnActions();
			cutomerpage.clickOnViewOption();
			Assert.assertEquals(cutomerpage.checkCustomerinfo(), "Customer info");
			
		}
		
	    @Test
		public void addVariations()
		{
			loginpage.loginToQAlengend(props.getProperty("username"), props.getProperty("password"));
			homepage.clickOnEndTourButton();
			homepage.clickOnProductsAction();
			varitationspage.clickOnVariationsOption();
			varitationspage.clickOnAddVariationButton();
			Random rand= new Random();
			int randomnumber= rand.nextInt(10000);
			String variationname=props.getProperty("variationname")+randomnumber;
			varitationspage.enterVariationName(variationname);
			String variationvalue=props.getProperty("addvariationvalues")+randomnumber;
			varitationspage.enterVariationvalue(variationvalue);
			varitationspage.enterSaveButton();
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));		
			wait.until(ExpectedConditions.visibilityOf(varitationspage.searchtextbox));
		    varitationspage.enterSearchvalue(variationname);			
			Assert.assertEquals(varitationspage.checkaddedVariations(), variationname);
		}
		
	  
	 @Test 
		public void addSellingPrice()
		{
			loginpage.loginToQAlengend(props.getProperty("username"), props.getProperty("password"));
			homepage.clickOnEndTourButton();
			homepage.clickOnProductsAction();
			homepage.clickOnSellingPriceGroup();
			sellingpricegroup.clickOnAddButton();
			Random rand= new Random();
			int randomnumber= rand.nextInt(10000);
			String sellingpricename=props.getProperty("sellingpricename")+randomnumber;
			String sellingpricedesc=props.getProperty("sellingpricedesc")+randomnumber;
			sellingpricegroup.enterOnSellingPriceName(sellingpricename);
			sellingpricegroup.enterOnSellingPriceDesc(sellingpricedesc);
			sellingpricegroup.clickOnSaveButton();
			sellingpricegroup.enterSearchText(sellingpricename);
			Assert.assertEquals(sellingpricegroup.elementtoVerify(), sellingpricename); 
		}
	 
	 @Test
	 public void addBrands() throws Exception
	 {
		 loginpage.loginToQAlengend(props.getProperty("username"), props.getProperty("password"));
			homepage.clickOnEndTourButton();
			homepage.clickOnProductsAction();
			homepage.clickOnBrandName();
			brandpage.clickOnAddButton();
			Random rand= new Random();
			int randomnumber= rand.nextInt(10000);
			String addnametextbox=props.getProperty("addnametextbox")+randomnumber;
			String adddescriptiontextbox=props.getProperty("adddescriptiontextbox")+randomnumber;
			brandpage.enterNameTextBox(addnametextbox);
			brandpage.enterDescriptionTextBox(adddescriptiontextbox);
			brandpage.clickOnSaveButton();
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(brandpage.searchtextbox));
			brandpage.enterTextToSearch(adddescriptiontextbox);	
			Assert.assertEquals(brandpage.brandToBeVerified(), addnametextbox); 
			 }
	 @Test
	 public void editBrands() throws Exception
	 {
		 loginpage.loginToQAlengend(props.getProperty("username"), props.getProperty("password"));
			homepage.clickOnEndTourButton();
			homepage.clickOnProductsAction();
			homepage.clickOnBrandName();
			brandpage.clickOnAddButton();
			Random rand= new Random();
			int randomnumber= rand.nextInt(10000);
			String addnametodelete=props.getProperty("addnametodelete")+randomnumber;
			String adddescriptiontodelete=props.getProperty("adddescriptiontodelete")+randomnumber;
			brandpage.enterNameTextBox(addnametodelete);
			brandpage.enterDescriptionTextBox(adddescriptiontodelete);
			brandpage.clickOnSaveButton();
			//WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			//wait.until(ExpectedConditions.visibilityOf(brandpage.searchtextbox));
			Thread.sleep(10000);
			brandpage.enterTextToSearch(adddescriptiontodelete);	
			brandpage.clickOnDeleteButton();
			Assert.assertEquals(brandpage.validationMessageVerificationOnDelete(), "No matching records found");
			
	 }
}
