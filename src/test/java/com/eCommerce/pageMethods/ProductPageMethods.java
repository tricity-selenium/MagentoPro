package com.eCommerce.pageMethods;

import org.openqa.selenium.WebDriver;

import com.eCommerce.pageObjects.ProductPageObjects;
import com.eCommerce.utilities.WebDriverMethods;

public class ProductPageMethods extends WebDriverMethods{
	
	ProductPageObjects productPageObjects;

	public ProductPageMethods(WebDriver driver) {
		super(driver);
		
		productPageObjects = new ProductPageObjects(driver);
	}
	
	
	
	public void clickAddProduct()
	
	{
		
		clickElement(productPageObjects.addProduct);
	}

}
