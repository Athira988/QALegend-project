package PageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;
import Utilities.WaitUtility;

public class QAlegendRolePageNew {
	
	WebDriver driver;

	@FindBy(xpath="//a[@class='btn btn-block btn-primary']")
	WebElement addButton;
	
	@FindBy(id="name")
	WebElement rolenametextbox;
	
	@FindBy(xpath="(//ins[@class='iCheck-helper'])[2]")
	WebElement selectallusercheckbox;
	
	@FindBy(xpath="//input[@class='form-control input-sm']")
	WebElement searchtextbox;
	
	@FindBy(xpath="//button[text()='Save']")
	WebElement saveButton; 
	
	@FindBy(xpath="//div[@id='roles_table_filter']//child::input")
	WebElement rolesearchtextbox;
	
	@FindBy(xpath="//tr[@class='odd']//child::button")
	WebElement deleteButton;
	
	@FindBy(xpath="//button[text()='OK']")
	WebElement okButton;
	
	@FindBy(xpath="//tr[@class='odd']//child::a")
	WebElement editButton;
	
	@FindBy(xpath="(//div[@class='icheckbox_square-blue']//child::ins)[2]")
	WebElement roleeditcheckbox;
	
	@FindBy(xpath="//button[text()='Update']")
	WebElement updateButton;
	
	
	@FindBy(xpath="//td[@class='sorting_1']")
	WebElement addedrolename;
	
	@FindBy(xpath="(//div[@class='icheckbox_square-blue checked'])[1]")
	WebElement checkeditrole;
	
	@FindBy(xpath="//td[@class='dataTables_empty']")
	WebElement validationmessagefordelete;
	
	//@FindBy(xpath="//a[@class='btn btn-xs btn-primary']")
	//WebElement editbotton;
	
	
	
	public QAlegendRolePageNew(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnAddButton()
	{
		PageUtilities.clickOnElement(addButton);
	}
	
	
	public void clickOnUserCheckBox()
	{
		PageUtilities.clickOnElement(selectallusercheckbox);
	}
	
	public void enterTexttoSearch()
	{
		PageUtilities.enterText(searchtextbox, "sales");
	}

	public void enterTextToadd(String property) {
		// TODO Auto-generated method stub
		PageUtilities.enterText(rolenametextbox, property);
	}
	
	public void clickOnSaveButton()
	{
		PageUtilities.clickOnElement(saveButton);
	}
	
	public void enterroleTextToSearch(String role)
	{
		PageUtilities.enterText(rolesearchtextbox, role);
	}
	
	public void clickOnDeleteButton()
	{
		
		JavascriptExecutor executer= (JavascriptExecutor)driver;
		executer.executeScript("arguments[0]", deleteButton);
		WaitUtility.waitforElementToBeVisible(deleteButton, 10);
		PageUtilities.clickOnElement(deleteButton);
	}
	
	public void clickOnOkButton()
	{
		PageUtilities.clickOnElement(okButton);
	}
	public void clickOnEditButton()
	{
		JavascriptExecutor executer= (JavascriptExecutor)driver;
		executer.executeScript("arguments[0]", editButton);
		
		PageUtilities.clickOnElement(editButton);
	}
	
	public void clickOnroleEditCheckBox()
	{
		PageUtilities.clickOnElement(roleeditcheckbox);
	}
	
	public void clickOnUpdateButton()
	{
		PageUtilities.clickOnElement(updateButton);
	}
	
	public String getaddedRole()
	{
		 return (PageUtilities.getElementText(addedrolename));
		 
	}
	
	public boolean checkEditedRole()
	{
		return (PageUtilities.isElementSelected(checkeditrole));
	}
	
	public String checktheValidationDelete()
	{
		return(PageUtilities.getElementText(validationmessagefordelete));
	}
	
	
	
}
