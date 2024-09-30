package PageClasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QAlegendSellingPriceGroupPageNew {
	WebDriver driver;
	
	@FindBy (xpath="//div[@class='box-tools']")
	WebElement sellingpriceaddbutton;
	
	@FindBy(id="name")
	WebElement sellingpricename;
	
	@FindBy(name="description")
	WebElement sellingpricedesc;
	
	@FindBy(xpath="//button[text()='Save']")
	WebElement saveButton;
	
	@FindBy(xpath="//input[@class='form-control input-sm']")	 
	WebElement searchtextbox;
	
	@FindBy(xpath="//td[@class='sorting_1']")
	WebElement elementtoverify;
	
	
	public QAlegendSellingPriceGroupPageNew(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}



	public void clickOnAddButton()
	{
		PageUtilities.clickOnElement(sellingpriceaddbutton);		
	}
	public void enterOnSellingPriceName(String name)
	{
		PageUtilities.enterText(sellingpricename, name);
	}
	
	public void enterOnSellingPriceDesc(String desc)
	{
		PageUtilities.enterText(sellingpricedesc, desc);
	}
	public void clickOnSaveButton()
	{
		PageUtilities.clickOnElement(saveButton);		
	}
	public void enterSearchText(String searchtext)
	{
		JavascriptExecutor executer= (JavascriptExecutor)driver;
		executer.executeScript("arguments[0]", searchtextbox);
		PageUtilities.enterText(searchtextbox, searchtext);	
	}
	
	
	public String elementtoVerify()
	{
		return(PageUtilities.getElementText(elementtoverify));
	}
}
