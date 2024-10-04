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
	public
	WebElement searchtextbox;
	
	@FindBy(xpath="(//tr[@class='odd']//child::td)[2]")
	WebElement addedbrandname;
	
	@FindBy(xpath="(//td[@class='sorting_1']")
	WebElement brandtobeverfied;
	
	@FindBy(xpath="//div[@id='brands_table_info']")
	WebElement valdatationmessage;
	
	@FindBy(xpath="//button[@class='btn btn-xs btn-danger delete_brand_button']")
	public
	WebElement deletbutton;
	
	@FindBy(xpath="//button[text()='OK']")
	public
	WebElement okButton;
	
	@FindBy(xpath="//tr[@class='odd']//child::td")
	WebElement validationmessageonDelete;
	
	public QAlegentBrandsPageNew(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}



	public void clickOnAddButton()
	{
		PageUtilities.clickOnElement(addbutton);;
	}
   
	 public void enterNameTextBox(String name)
	 {
		 PageUtilities.enterText(addnametextbox, name);
	 }
	
	 public void enterDescriptionTextBox(String desc)
	 {
		 PageUtilities.enterText(adddescriptiontextbox,desc);
	 }
	 
	 public void clickOnSaveButton()
	 {
		 PageUtilities.clickOnElement(saveButton);
	 }
	 
	 
	 
	 public void enterTextToSearch(String text)
	 {
		 JavascriptExecutor executer= (JavascriptExecutor)driver;
			executer.executeScript("arguments[0]", searchtextbox);
			WaitUtility.waitforElementToBeVisible(searchtextbox, 15);
			PageUtilities.enterText(searchtextbox, text);
	 }
	 
	 public String verifyTheAddedBrandName()
	 {
		 return(PageUtilities.getElementText(addedbrandname));
	 }
	 
	 public String brandToBeVerified()
	 {
		 WaitUtility.waitforElementToBeVisible(brandtobeverfied, 10);
		 return(PageUtilities.getElementText(brandtobeverfied));
	 }
	 
	 public String validationMessageVerification()
	 {
		 return(PageUtilities.getElementText(valdatationmessage));
	 }
	 
	 public void clickOnDeleteButton()
	 {
		 //JavascriptExecutor executer= (JavascriptExecutor)driver;
		//	executer.executeScript("arguments[0]", deletbutton);
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
