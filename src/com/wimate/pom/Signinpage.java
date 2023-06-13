package com.wimate.pom;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Signinpage {
	@FindBy(linkText = "Sign up")
	WebElement signup;
	@FindBy(id = "username")
	WebElement un;
	@FindBy(id = "password")
	WebElement pwd;
	@FindBy(xpath = "//button[text()='Sign in']")
	WebElement click;
	public Signinpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void signup() throws InterruptedException
	{
		Thread.sleep(3000);
		signup.click();
	}
	public void login(WebDriver driver) throws EncryptedDocumentException, IOException, InterruptedException
	{
		FileInputStream fis=new FileInputStream("./data/values.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int lastrow = wb.getSheet("Sheet1").getLastRowNum();
		System.out.println(lastrow);
		for(int i=1;i<=lastrow;i++)
		{
			String name = wb.getSheet("Sheet1").getRow(i).getCell(0).getStringCellValue();
			String pass = wb.getSheet("Sheet1").getRow(i).getCell(1).getStringCellValue();
			System.out.println(name+"-->"+pass);
			Thread.sleep(3000);
			un.sendKeys(name);
			Thread.sleep(2000);
			pwd.sendKeys(pass);
			click.click();
			Thread.sleep(9000);
			String title=driver.getTitle();
			String atitle="Cloudtesla | Dashboard";
			if(!(title.equals(atitle)))
			{
				System.out.println("Is not loginpage displayed");
				driver.navigate().refresh();

			}
			else if(title.equals(atitle))
			{
				System.out.println("Is loginnpage displayed");
				break;
			}
			



		}

	}
}
