package com.eCommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class DashboardPageObjects {
	
	
	public DashboardPageObjects(WebDriver driver)
	{
		
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
	}
	
	
	public @FindBy(xpath="//*[@id=\'html-body\']/div[2]/header/div[2]/div[1]/a/span/span") WebElement adminName;
	//public @FindBy(xpath="//span") WebElement adminName;
	public @FindBy(linkText = "Sign Out") WebElement signOut;
	public @FindBy(id = "menu-magento-catalog-catalog") WebElement catalog;
	public @FindBy(linkText = "Products") WebElement products;
	
}
