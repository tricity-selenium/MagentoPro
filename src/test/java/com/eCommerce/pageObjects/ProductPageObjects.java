package com.eCommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ProductPageObjects {
	
	public ProductPageObjects(WebDriver driver)
		
	{
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
		
	}
	
	
	public @FindBy(id = "add_new_product-button") WebElement addProduct;

}
