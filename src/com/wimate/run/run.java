package com.wimate.run;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.wimate.generic.BaseClass;
import com.wimate.pom.Homepage;
import com.wimate.pom.Signinpage;
import com.wimate.pom.Signuppage;

public class run extends BaseClass{
	@Test(priority = 1)
	public void couldSingup() throws EncryptedDocumentException, IOException, InterruptedException
	{
		Reporter.log("couldSingup",true);
		Signinpage s=new Signinpage(driver);
		s.signup();
		Signuppage s1=new Signuppage(driver);
		s1.signup(driver);
		Homepage h=new Homepage(driver);
		h.home();
		
	}
	@Test(priority = 2)
	public void couldSingIn() throws EncryptedDocumentException, IOException, InterruptedException
	{
		Reporter.log("couldSingIn",true);
		WebDriver driver = null;
		Signinpage s=new Signinpage(driver);
		s.login(driver);
		Homepage h=new Homepage(driver);
		h.home();
		
	}
	
	}
