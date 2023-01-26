package com.eCommerce.driverScript1;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.eCommerce.utilities.InitializeBrowser;

public class script1 extends InitializeBrowser{
	
	@Test(priority =1)
	public void userlogin()
	
	{
		consoleLog("Log in into to application");
		loginPageMethods.doLogin("magebit", "Demo123");
		Assert.assertEquals(driver.getTitle(), "Dashboard / Magento Admin");
		consoleLog("Page title is correct");
	}
	
	@Test(priority =2)	
	public void gotoAddProduct()
		
		{
		
		    dashboardPageMethods.gotoProductsList();
			consoleLog("Going to add Products");
		    productPageMethods.clickAddProduct();
		    consoleLog("Clicked Add Product");
		    Assert.assertEquals(driver.getTitle(), "New Product / Products / Inventory / Catalog / Magento Admin");
			consoleLog("Page title is correct");
			
		}
	
		/*
		 * @Test(priority =3) public void addProduct()
		 * 
		 * {
		 * 
		 * 
		 * consoleLog("entered product info"); addProductPageMethods.saveProduct();
		 * Assert.assertEquals(addProductPageMethods.getAddProductMsg(),
		 * "You saved the product.");
		 * 
		 * 
		 * }
		 */
	
	
	@Test(priority =4)	
public void userlogOut() throws InterruptedException
	
	{
		Thread.sleep(3000);
		consoleLog("Logging out of application");
		dashboardPageMethods.signOut();
		consoleLog("Logged out");
		Assert.assertEquals(loginPageMethods.getLogoutMsg(), "You have logged out.");
		consoleLog("Logged out message appeared");
	}
	
	
	

}
