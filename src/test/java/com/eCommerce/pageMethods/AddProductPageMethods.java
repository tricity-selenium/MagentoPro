package com.eCommerce.pageMethods;

import org.openqa.selenium.WebDriver;

import com.eCommerce.pageObjects.AddProductPageObjects;
import com.eCommerce.utilities.WebDriverMethods;

public class AddProductPageMethods extends WebDriverMethods{

	AddProductPageObjects addProductPageObjects;
	public AddProductPageMethods(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		addProductPageObjects = new AddProductPageObjects(driver);
	}
	
	public void saveProduct()
	{
		
		sendKeysinElement(addProductPageObjects.productName, "deepakTesting");
		sendKeysinElement(addProductPageObjects.productSKU, "123");
		sendKeysinElement(addProductPageObjects.productPrice, "100");
		sendKeysinElement(addProductPageObjects.productQuantity, "10");
		sendKeysinElement(addProductPageObjects.productWeight, "5");
		clickElement(addProductPageObjects.productCategory);
		clickElement(addProductPageObjects.productCategoryOption);
		clickElement(addProductPageObjects.doneButton);
		selectByVisibleText(addProductPageObjects.countryOfManufacturer, "India");
		clickElement(addProductPageObjects.saveButton);
		
	}
	
	
	public String getAddProductMsg()
	{
		return getElementText(addProductPageObjects.addProductMsg);
		
		
	}

}
