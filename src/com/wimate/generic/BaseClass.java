package com.wimate.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.wimate.pom.Homepage;
import com.wimate.pom.Signinpage;

public class BaseClass {
static
{
	System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
}
public WebDriver driver;
@BeforeClass
public void openBrowser()
{
	Reporter.log("openBrowser",true);
	driver=new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
}
@BeforeMethod
public void signup()
{
	Reporter.log("signup",true);
	driver.get("https://e2e.cloudtesla.com/");
	
}
@AfterMethod
public void signout() throws InterruptedException
{
	Reporter.log("signout",true);
	
	
}
@AfterClass
public void closeBrowser()
{
	Reporter.log("closeBrowser",true);
	driver.close();
}

}
