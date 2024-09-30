package PageClasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

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
	
	@FindBy(xpath="//td[@class='sorting_1']")
	WebElement brandtobeverfied;
	
	@FindBy(xpath="//div[@id='brands_table_info']")
	WebElement valdatationmessage;
	
	@FindBy(xpath="//button[text()=' Delete']")
	WebElement deletbutton;
	
	@FindBy(xpath="//button[text()='OK']")
	WebElement okButton;
	
	@FindBy(xpath="//td[text()='No matching records found']")
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
			PageUtilities.enterText(searchtextbox, text);
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
		 PageUtilities.clickOnElement(deletbutton);
	 }
	 
	 public void clickOnOkButton()
	 {
		 PageUtilities.clickOnElement(okButton);
	 }
	 public String validationMessageVerificationOnDelete()
	 {
		 return(PageUtilities.getElementText(validationmessageonDelete));
	 }
}
