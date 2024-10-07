package PageClasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;
import Utilities.WaitUtility;

public class QAlegentBrandsPageNew {
	
	WebDriver driver;
	
	@FindBy(xpath="//button[@class='btn btn-block btn-primary btn-modal']")
	WebElement addbutton;
	
	@FindBy(xpath="//input[@id='name']")
	WebElement addnametextbox;
	
	@FindBy(xpath="//input[@id='description']")
	WebElement adddescriptiontextbox;
	
	@FindBy(xpath="//button[text()='Save']")
	WebElement saveButton;
	
	@FindBy(xpath="//input[@class='form-control input-sm']")	
	WebElement searchtextbox;
	
	@FindBy(xpath="(//tr[@class='odd']//child::td)[2]")
	WebElement addedbrandname;
	
	@FindBy(xpath="(//tr[@class='odd']//child::td)[1]")
	WebElement brandtobeverfied;
	
	@FindBy(xpath="//div[@id='brands_table_info']")
	WebElement valdatationmessage;
	
	@FindBy(xpath="//button[@class='btn btn-xs btn-danger delete_brand_button']")	
	WebElement deletbutton;
	
	@FindBy(xpath="//button[text()='OK']")	
	WebElement okButton;
	
	@FindBy(xpath="//tr[@class='odd']//child::td")
	WebElement validationmessageonDelete;
	
	public QAlegentBrandsPageNew(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}



	public void clickOnAddButton()
	{
		
		addbutton.clear();
	}
   
	 public void enterNameTextBox(String name)
	 {
		
		 addnametextbox.sendKeys(name);
	 }
	
	 public void enterDescriptionTextBox(String desc)
	 {
		 
		 adddescriptiontextbox.sendKeys(desc);
	 }
	 
	 public void clickOnSaveButton()
	 {
		 saveButton.click();
	 }
	 
	 
	 
	 public void enterTextToSearch(String text)
	 {
		 searchtextbox.sendKeys(text);
			
	 }
	 
	 public String verifyTheAddedBrandName()
	 {
		 return(PageUtilities.getElementText(addedbrandname));
	 }
	 
	 public String brandToBeVerified()
	 {
		 
		 return(PageUtilities.getElementText(brandtobeverfied));
	 }
	 
	 public String validationMessageVerification()
	 {
		 return(PageUtilities.getElementText(valdatationmessage));
	 }
	 
	 public void clickOnDeleteButton()
	 {
		 
		 WaitUtility.waitforElementToBeVisible(deletbutton, 10);
			PageUtilities.clickOnElement(deletbutton);
		 
	 }
	 
	 public void clickOnOkButton()
	 {
		 WaitUtility.waitforElementToBeVisible(okButton, 10);
		 PageUtilities.clickOnElement(okButton);
	 }
	 public String validationMessageVerificationOnDelete()
	 {
		 WaitUtility.waitforElementToBeVisible(validationmessageonDelete, 15);
		 return(PageUtilities.getElementText(validationmessageonDelete));
	 }
}
