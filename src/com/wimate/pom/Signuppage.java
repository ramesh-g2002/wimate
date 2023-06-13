package com.wimate.pom;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Signuppage {
	@FindBy(id = "firstName")
	WebElement fname;
	@FindBy(id = "lastName")
	WebElement lname;
	@FindBy(id = "mobile")
	WebElement mob;
	@FindBy(id = "email")
	WebElement emailtbx;
	@FindBy(id = "username")
	WebElement untbx;
	@FindBy(id = "password")
	WebElement pwdtbx;
	@FindBy(id = "desc")
	WebElement destbx;
	@FindBy(xpath = "//button[text()='Sign up']")	
	WebElement signup;
	public Signuppage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void signup(WebDriver driver) throws EncryptedDocumentException, IOException, InterruptedException
	{
		FileInputStream fis=new FileInputStream("./data/testScript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int lastrow = wb.getSheet("Sheet1").getLastRowNum();
		System.out.println(lastrow);
		for(int i=1;i<=lastrow;i++)
		{
			Thread.sleep(3000);
			String name=wb.getSheet("Sheet1").getRow(i).getCell(0).getStringCellValue();
			String cid=wb.getSheet("Sheet1").getRow(i).getCell(1).getStringCellValue();
			String pno = String.valueOf((int)wb.getSheet("Sheet1").getRow(i).getCell(2).getNumericCellValue());
			String email=wb.getSheet("Sheet1").getRow(i).getCell(3).getStringCellValue();
			String un=wb.getSheet("Sheet1").getRow(i).getCell(4).getStringCellValue();
			String dis=wb.getSheet("Sheet1").getRow(i).getCell(5).getStringCellValue();
			String pwd=wb.getSheet("Sheet1").getRow(i).getCell(6).getStringCellValue();
			System.out.println(name+"-->"+cid+"-->"+pno+"-->"+email+"-->"+un+"-->"+dis+"-->"+pwd);
			Thread.sleep(3000);
			fname.sendKeys(name);
			lname.sendKeys(cid);
			mob.sendKeys(pno);
			emailtbx.sendKeys(email);
			untbx.sendKeys(un);
			pwdtbx.sendKeys(pwd);
			destbx.sendKeys(dis);
			Thread.sleep(3000);
			signup.click();
			Thread.sleep(6000);
			String title=driver.getTitle();
			String atitle="Cloudtesla | Dashboard";
			System.out.println(title+"--->"+atitle);
			Thread.sleep(3000);
			if(title.equals(atitle))
			{
				System.out.println("Is signinpage displayed");
				break;
				
			}
			else if(!(title.equals(atitle)))
			{
				System.out.println("Is not signinpage displayed");
				driver.navigate().refresh();
				
			}
		}
	}

}
