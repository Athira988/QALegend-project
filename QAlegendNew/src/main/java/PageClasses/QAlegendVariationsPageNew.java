package PageClasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;
import Utilities.WaitUtility;

public class QAlegendVariationsPageNew {

	WebDriver driver;
	
	@FindBy (xpath="//span[text()='Variations']")
	WebElement variationsoption;
	
	@FindBy(xpath="//div[@class='box-tools']//child::button")
	WebElement addbutton;
	
	@FindBy(id="name")
	WebElement variationname;
	
   @FindBy(xpath="(//input[@class='form-control'])[2]")
   WebElement addvariationvalues;
   
   @FindBy(xpath="//button[text()='Save']")
   WebElement savebutton;
   
   @FindBy(xpath="//input[@class='form-control input-sm']")
public
   WebElement searchtextbox;
   
   @FindBy(xpath="//a[@class='btn buttons-collection btn-info']")
   WebElement actionbutton;
   
   @FindBy(xpath="//i[@class='fa fa-file-excel-o']")
   WebElement excelexport;
	
   @FindBy(xpath="//td[@class='sorting_1']")
	WebElement addedvariationname;
	
   @FindBy(xpath="(//td[@class='sorting_1']//following-sibling::td)[1]")
   WebElement addedvariationdesc;
	
	
	 public QAlegendVariationsPageNew(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	public void clickOnVariationsOption()
	{
		
		variationsoption.click();
	}
	
	public void clickOnAddVariationButton()
	{
		
		addbutton.click();
	}
	
	public void enterVariationName(String name)
	{
		
		variationname.sendKeys(name);
	}
	
	public void enterVariationvalue(String name)
	{
		
		addvariationvalues.sendKeys(name);
	}
	
	public void enterSaveButton()
	{
		
		savebutton.click();
	}
	
	public void enterSearchvalue(String searchtext)
	{
		//JavascriptExecutor executer= (JavascriptExecutor)driver;
		//executer.executeScript("arguments[0]", searchtextbox);
		WaitUtility.waitforElementToBeVisible(searchtextbox, 15);
		PageUtilities.enterText(searchtextbox, searchtext);
	}
	
	public void clickActionButton()
	{
		
		actionbutton.click();
	}
	public void clickOnExporttoExcel()
	{
		
		excelexport.click();
	}
	public String checkaddedVariations()
	{
		
		return(PageUtilities.getElementText(addedvariationdesc));
	}
}
