package com.eCommerce.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.eCommerce.pageMethods.AddProductPageMethods;
import com.eCommerce.pageMethods.DashboardPageMethods;
import com.eCommerce.pageMethods.LoginPageMethods;
import com.eCommerce.pageMethods.ProductPageMethods;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InitializeBrowser {
	
	public WebDriver driver;
	
	public WebDriverMethods webDriverMethods;
	public LoginPageMethods loginPageMethods;
	public DashboardPageMethods dashboardPageMethods;
	public ProductPageMethods productPageMethods;
	public AddProductPageMethods addProductPageMethods;
	public static ExtentReports report;
	public ExtentTest test;
	public static ExtentHtmlReporter extentHtmlReporter;
	public String methodName;
	
	
	public void initializevariables()
	
	{
		webDriverMethods = new WebDriverMethods(driver);
		
		loginPageMethods = new LoginPageMethods(driver);
		
		dashboardPageMethods = new DashboardPageMethods(driver);
		
		productPageMethods = new ProductPageMethods(driver);
		
		addProductPageMethods = new AddProductPageMethods(driver);
	}
	
	@BeforeSuite
	public void initiateReports()
	{
		report = new ExtentReports();
		String filePath = System.getProperty("user.dir")+"//TestReport//Report.html";
		extentHtmlReporter = new ExtentHtmlReporter(new File(filePath));
		report.attachReporter(extentHtmlReporter);
		
		
	}
	
	/*
	 * public void openbrowser() { System.setProperty("webdriver.chrome.driver",
	 * "F:\\driver\\chromedriver.exe");
	 * 
	 * driver = new ChromeDriver();
	 * driver.get("https://magento2-demo.magebit.com/admin");
	 * System.out.println("browser opened"); initializevariables();
	 * System.out.println("variable initialized"); }
	 */
	
	public void openbrowser()
	{
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
        driver.get("https://magento2-demo.magebit.com/admin");
        initializevariables();
	}
	
	
	@BeforeTest
	public void setUp()
	{
		openbrowser();
		
	}
	
	@BeforeMethod
	public void getMethodName(Method method)
	{

		 methodName = method.getName();

		System.out.println("\n\n*******************************************************************************\n");
		System.out.println("\tExecuting "+methodName+" testcase");
		System.out.println("\n*******************************************************************************\n");

		test = report.createTest(methodName);

		
	}
	@AfterMethod
	public void setTestResult(ITestResult result, Method method) throws IOException
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, "Test is passed");
		}
		else
			if (result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, "failed");
			webDriverMethods.takeScreenshot(methodName);
			//test.log(Status.FAIL, "Screenshot Below" + test.addScreencastFromPath("C:\\Users\\HP\\deepak_workspace\\magentoPro\\screenshots\\"+methodName+".png"));
			test.log(Status.FAIL , (Markup) test.addScreenCaptureFromPath("C:\\Users\\HP\\deepak_workspace\\magentoPro\\screenshots\\"+methodName+".png"));
			
		}
	}
	
	
	
	@AfterSuite(alwaysRun=true)
	public void generateReport() throws IOException
	{
		if(!driver.equals(null))
			//driver.quit();
		   
			report.flush();
	}
	
	
	public void consoleLog(String message)
	{
		System.out.println(message+"\n");
		test.log(Status.INFO, message);
	}
	
	

}
