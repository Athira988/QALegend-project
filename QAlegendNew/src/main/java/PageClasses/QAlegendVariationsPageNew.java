package PageClasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

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
	
	
	
	 public QAlegendVariationsPageNew(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	public void clickOnVariationsOption()
	{
		PageUtilities.clickOnElement(variationsoption);
	}
	
	public void clickOnAddVariationButton()
	{
		PageUtilities.clickOnElement(addbutton);
	}
	
	public void enterVariationName(String name)
	{
		PageUtilities.enterText(variationname, name);
	}
	
	public void enterVariationvalue(String name)
	{
		PageUtilities.enterText(addvariationvalues, name);
	}
	
	public void enterSaveButton()
	{
		PageUtilities.clickOnElement(savebutton);
	}
	
	public void enterSearchvalue(String searchtext)
	{
		JavascriptExecutor executer= (JavascriptExecutor)driver;
		executer.executeScript("arguments[0]", searchtextbox);
		PageUtilities.clickOnElement(searchtextbox);
		PageUtilities.enterText(searchtextbox, searchtext);
	}
	
	public void clickActionButton()
	{
		PageUtilities.clickOnElement(actionbutton);
	}
	public void clickOnExporttoExcel()
	{
		PageUtilities.clickOnElement(excelexport);
	}
	public String checkaddedVariations()
	{
		return(PageUtilities.getElementText(addedvariationname));
	}
}
