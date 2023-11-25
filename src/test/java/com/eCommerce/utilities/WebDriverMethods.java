package com.eCommerce.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverMethods {
	
	public WebDriver driver;
	public Actions action;
	public Select dropDown;

	WebDriverWait wait;
	TakesScreenshot shot;
	
	public WebDriverMethods(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebDriver getWebDriver()
	{
		return driver;
		
	}
	
	
	public WebDriverWait getWait(int timeOutInSeconds)
	{
		wait = new WebDriverWait(driver, timeOutInSeconds);
		return wait;
		
	}
	
	
	public void waitForElementVisible(WebElement locator, int timeOutInSecond)
	{
		getWait(timeOutInSecond).until(ExpectedConditions.visibilityOf(locator));
	}

	
	public void waitForElementClickable(WebElement locator, int timeOutInSecond) 
	{
		getWait(timeOutInSecond).until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	
	public void clickElement(WebElement locator)
	{
		waitForElementVisible(locator, 10);
		waitForElementClickable(locator, 10);
		locator.click();		
		
	}
	
	public void sendKeysinElement(WebElement locator, String text)
	{
		waitForElementVisible(locator, 10);
		//waitForElementClickable(locator, 10);
		locator.sendKeys(text);	
		
	}
	
	public String getElementText(WebElement locator)
	{
		return locator.getText();
		
	}
	
	public void takeScreenshot(String name) throws IOException
	{
		shot = (TakesScreenshot)driver;
		File srcFile = shot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File("C:\\Users\\HP\\deepak_workspace\\magentoPro\\screenshots\\"+name+".png");
		FileUtils.copyFile(srcFile, DestFile);
		
	}
	
	public Actions getAction ()
	
	{
		
		return action = new Actions(driver);
		
	}
	
	public void moveToElement(WebElement locator)
	{
		
		getAction().moveToElement(locator).build().perform();
	}
	
public Select getDropDown (WebElement locator)
	
	{
		
		return dropDown = new Select(locator);
		
	}

public void selectByVisibleText(WebElement locator, String text)

{
	getDropDown(locator).selectByVisibleText(text);
	
}
	

}
