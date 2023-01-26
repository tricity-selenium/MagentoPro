package com.eCommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPageObjects {
	
	
	public LoginPageObjects(WebDriver driver)
	{
		System.out.println("login objects initialized");
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
	}
	
	public @FindBy(id = "username") WebElement usernameField;
	public @FindBy(id = "login")    WebElement passwordField;
	public @FindBy(xpath = "//*[@id=\'login-form\']/fieldset/div[3]/div[1]/button/span") WebElement signInButton;
	public @FindBy(xpath ="//*[@id=\'html-body\']/section/div/div/div/div") WebElement logoutMsg;
  	

}
