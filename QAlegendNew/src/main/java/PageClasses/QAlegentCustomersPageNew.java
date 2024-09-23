package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtilities;

public class QAlegentCustomersPageNew {
	
	WebDriver driver;
	
	@FindBy(xpath="(//div[@class='btn-group']//child::button)[1]")
	public
	WebElement actiondropdown;
	
	
	@FindBy(xpath="((//ul[@class='dropdown-menu dropdown-menu-right'])[1]//child::a)[1]")
	WebElement viewoption;
	
	@FindBy(xpath="(//h3[@class='box-title'])[1]")
	WebElement customerinfo;
	
	
	
	
	
	
	public QAlegentCustomersPageNew(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver=driver;
		PageFactory.initElements(driver, this);
	}







	public void clickOnActions()
	{
		PageUtilities.clickOnElement(actiondropdown);
	}
	public void clickOnViewOption()
	{
		PageUtilities.clickOnElement(viewoption);
	}
	public String checkCustomerinfo()
	{
		return(PageUtilities.getElementText(customerinfo));
	}
	
	
}
