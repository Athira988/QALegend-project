package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QAlegentBrandsPageNew {
	
	WebDriver driver;
	
	@FindBy(xpath="//button[@class='btn btn-block btn-primary btn-modal']")
	WebElement addbutton;

}
