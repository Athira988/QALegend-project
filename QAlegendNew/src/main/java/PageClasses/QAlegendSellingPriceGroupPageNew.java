package PageClasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;
import Utilities.WaitUtility;

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
		
		sellingpriceaddbutton.click();
	}
	public void enterOnSellingPriceName(String name)
	{
		
		sellingpricename.sendKeys(name);
	}
	
	public void enterOnSellingPriceDesc(String desc)
	{
		
		sellingpricedesc.sendKeys(desc);
	}
	public void clickOnSaveButton()
	{
		
		saveButton.click();
	}
	public void enterSearchText(String searchtext)
	{
		JavascriptExecutor executer= (JavascriptExecutor)driver;
		executer.executeScript("arguments[0]", searchtextbox);
		WaitUtility.waitforElementToBeVisible(searchtextbox, 20);
		PageUtilities.enterText(searchtextbox, searchtext);	
	}
	
	
	public String elementtoVerify()
	{
		WaitUtility.waitforElementToBeVisible(elementtoverify, 10);
		return(PageUtilities.getElementText(elementtoverify));
	}
}
