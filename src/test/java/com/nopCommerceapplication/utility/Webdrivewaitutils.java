package com.nopCommerceapplication.utility;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Webdrivewaitutils {
	
	public static final int IMPLICIT_WAIT_TIME=10;
	public static final int PAGE_LOAD_TIME=15;
	public static final int EXPLICIT_WAIT_BASIC_TIME=30;
	
	WebDriver driver;
	
	public Webdrivewaitutils(WebDriver driver) {
		
	this.driver = driver;
		
	}
	
	public void clickOnElement(WebElement element,long durationInSeconds) {
		
		WebElement webElement = waitForElement(element,durationInSeconds);
		webElement.click();
		
	}
	
	public void typeTextIntoElement(WebElement element,String textToBeTyped,long durationInSeconds) {
		
		WebElement webElement = waitForElement(element,durationInSeconds);
		webElement.click();
		webElement.clear();
		webElement.sendKeys(textToBeTyped);
		
	}
	
	public WebElement waitForElement(WebElement element,long durationInSeconds) {
		
		WebElement webElement = null;
		
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
		return webElement;
		
	}
	
public WebElement waitFormultipleElement(List<WebElement> element,long durationInSeconds) {
		
		WebElement webElement = null;
		
		for(WebElement ele : element)
		{
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.elementToBeClickable(ele));
		}catch(Throwable e) {
			e.printStackTrace();
		}
		}
		return webElement;
		
	}
	
	public void selectOptionInDropdown(WebElement element,String dropDownOption,long durationInSeconds) {
		
		WebElement webElement = waitForElement(element,durationInSeconds);
		Select select = new Select(webElement);
		select.selectByVisibleText(dropDownOption);
		
	}
	
	public void selectdropdownwithselecttag(WebElement element,String dropDownOption,long durationInSeconds) {
		
		WebElement webElement = waitForElement(element,durationInSeconds);
		Select drp = new Select(webElement);
		
		List<WebElement> alloptions = drp.getOptions();

		for (WebElement option : alloptions) 
		{
			if (option.getText().equals(dropDownOption)) 
			{
				option.click();      
				break;
			}
		}	
	}
	
	public void selectdropdownwithnoselecttag(List<WebElement> alloptions,String dropDownOption,long durationInSeconds) {
	
		for (WebElement option : alloptions) 
		{
			WebElement webElement = waitForElement(option,durationInSeconds);
			
			if (webElement.getText().equals(dropDownOption)) 
			{
				option.click();      
				break;
			}
		}	
	}
	
	public void acceptAlert(long durationInSeconds) {
		
		Alert alert = waitForAlert(durationInSeconds);
		alert.accept();
		
	}
	
	public void dismissAlert(long durationInSeconds) {
		
		Alert alert = waitForAlert(durationInSeconds);
		alert.dismiss();
		
	}
	
	public Alert waitForAlert(long durationInSeconds) {
		
		Alert alert = null;
		
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
			alert = wait.until(ExpectedConditions.alertIsPresent());
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
		return alert;
		
	}
	
	public void mouseHoverAndClick(WebElement element,long durationInSeconds) {
		
		WebElement webElement = waitForVisibilityOfElement(element,durationInSeconds);	
		Actions actions = new Actions(driver);
		actions.moveToElement(webElement).click().build().perform();
		
	}
	
	public WebElement waitForVisibilityOfElement(WebElement element,long durationInSeconds) {
		
		WebElement webElement = null;
		
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.visibilityOf(element));
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
		return webElement;
		
	}
	
	public void javaScriptClick(WebElement element,long durationInSeconds) {
		
		WebElement webElement = waitForVisibilityOfElement(element,durationInSeconds);
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].click();",webElement);
		
	}
	
	public void javaScriptType(WebElement element,long durationInSeconds,String textToBeTyped) {
		
		WebElement webElement = waitForVisibilityOfElement(element,durationInSeconds);
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].value='"+textToBeTyped+"'",webElement);
		
	}
	
	public String getTextFromElement(WebElement element,long durationInSeconds) {
		
		WebElement webElement = waitForElement(element,durationInSeconds);
		return webElement.getText();
		
	}
	
	public boolean displayStatusOfElement(WebElement element,long durationInSeconds) {
		
		try {
			WebElement webElement = waitForVisibilityOfElement(element,durationInSeconds);
			return webElement.isDisplayed();
		}catch(Throwable e) {
			return false;
		}
		
	}
	
}
