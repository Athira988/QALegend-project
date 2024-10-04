package Utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {

static 	WebDriver driver;
	
	public  static  void waitforElementToBeClickable(WebElement element,int timeoutInSeconds)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public  static void waitforElementToBeVisible(WebElement element,int timeoutInSeconds)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public  static void waitforPageTitle(String element,int timeoutInSeconds)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		wait.until(ExpectedConditions.titleIs(element));
	}
	public  static void waitforAlertToBePresent(String element,int timeoutInSeconds)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	public static  void waitforFrameToBeAvailible(WebElement element,int timeoutInSeconds)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
	}
	public static  void waitforFrameToBeAvailible(WebElement element,int timeoutInSeconds,String value)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		wait.until(ExpectedConditions.textToBePresentInElement(element, value));
	}
	public static  void waitforTextMatches(WebElement element,int timeoutInSeconds,String value)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		wait.until(ExpectedConditions.textToBePresentInElement(element, value));
	}
	
}
