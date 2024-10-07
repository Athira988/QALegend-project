package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QAlegentHomePageNew {
	WebDriver driver;

	@FindBy(xpath="//span[text()='User Management']")
	WebElement UserManagementoption;

	@FindBy(xpath="(//span[@class='title'])[2]")
	WebElement usersoption;

   @FindBy(xpath="//button[text()='End tour']")
   WebElement endtourbutton;
   
   @FindBy(xpath="(//span[@class='title'])[3]")
	WebElement roleoption;
   
   @FindBy(xpath="//span[text()='Contacts']")
   WebElement contactsoption;
   
   @FindBy(xpath="(//i[@class='fa fa-star'])[2]")
   WebElement cutomersoption;
   
   @FindBy(xpath="//span[text()='Products']")
   WebElement productsoption;
   
   @FindBy(xpath="//span[text()='Selling Price Group']")
   WebElement sellingpricegroupoption;
   
   @FindBy(xpath="//span[text()='Brands']")
   WebElement brandoption;
   
   public QAlegentHomePageNew(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnEndTourButton()
	{
		
		endtourbutton.click();
		
	}
	public void clickOnUserMangementOption()
	{
		
		UserManagementoption.click();
	}

	public void clickOnUserAction()
	{
		
		usersoption.click();
	}
	
	public void clickOnRoleAction()
	{
		
		roleoption.click();
	}
	
	public void clickOnContactsAction()
	{
		PageUtilities.clickOnElement(contactsoption);
	}
	public void clickOnCustomersAction()
	{
		PageUtilities.clickOnElement(cutomersoption);
	}
	
	public void clickOnProductsAction()
	{
		PageUtilities.clickOnElement(productsoption);
	}
	public void clickOnSellingPriceGroup()
	{
		PageUtilities.clickOnElement(sellingpricegroupoption);
	}
	
	public void clickOnBrandName()
	{
		PageUtilities.clickOnElement(brandoption);
	}
	
}

