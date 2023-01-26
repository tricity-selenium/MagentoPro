package com.eCommerce.pageMethods;

import org.openqa.selenium.WebDriver;

import com.eCommerce.pageObjects.LoginPageObjects;
import com.eCommerce.utilities.WebDriverMethods;

public class LoginPageMethods extends WebDriverMethods{
	
	LoginPageObjects loginPageObjects;

	
	  public LoginPageMethods(WebDriver driver) 
	  { 
	  super(driver);
	  
	  loginPageObjects =  new LoginPageObjects(driver);
	  }
	  // TODO Auto-generated constructor stub }
	 
	
	public void doLogin(String username, String password)
	{
		System.out.println("in side do login");
		sendKeysinElement(loginPageObjects.usernameField, username);
		sendKeysinElement(loginPageObjects.passwordField, password);
		clickElement(loginPageObjects.signInButton);
		
		
	}
	
	
	public String getLogoutMsg()
	{
		return getElementText(loginPageObjects.logoutMsg);
		
	}
	
	

}
