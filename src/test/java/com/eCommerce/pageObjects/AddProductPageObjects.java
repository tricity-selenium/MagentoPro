package com.eCommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class AddProductPageObjects {
	
	public AddProductPageObjects(WebDriver driver)
	{
		
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
	}
	
	
	public @FindBy(name = "product[name]") WebElement productName;
	public @FindBy(name = "product[sku]") WebElement productSKU;
	public @FindBy(name = "product[price]") WebElement productPrice;
	public @FindBy(name = "product[quantity_and_stock_status][qty]") WebElement productQuantity;
	public @FindBy(name = "product[weight]") WebElement productWeight;
	public @FindBy(xpath = "//div[text()='Select...']") WebElement productCategory;
	public @FindBy(xpath = "//span[text()='Default Category']") WebElement productCategoryOption;
	public @FindBy(xpath = "//span[text()='Done']") WebElement doneButton;
	public @FindBy(name = "product[country_of_manufacture]") WebElement countryOfManufacturer;
	public @FindBy(id = "save-button") WebElement saveButton;
	public @FindBy(xpath ="//*[@id=\'messages\']/div/div/div") WebElement addProductMsg;
	
}
