package com.eCommerce.pageMethods;

import org.openqa.selenium.WebDriver;

import com.eCommerce.pageObjects.DashboardPageObjects;
import com.eCommerce.utilities.WebDriverMethods;

public class DashboardPageMethods extends WebDriverMethods{
    
	DashboardPageObjects dashbordPageObjects;
	public DashboardPageMethods(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		dashbordPageObjects = new DashboardPageObjects(driver);
	}
	
	
	public void signOut()
	{
		
		  
		 
		clickElement(dashbordPageObjects.adminName);
		clickElement(dashbordPageObjects.signOut);
	}
	
	
	public void gotoProductsList()
	{
		
		  //moveToElement(dashbordPageObjects.catalog);
		  clickElement(dashbordPageObjects.catalog);
		 // moveToElement(dashbordPageObjects.products);
		  clickElement(dashbordPageObjects.products);
		 
		
	}
	
	
	

}
