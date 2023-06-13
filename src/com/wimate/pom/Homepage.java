package com.wimate.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
@FindBy(className = "header-profile-image")
WebElement head;
@FindBy(linkText = "Signout")
WebElement snout;
public Homepage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
public void home() throws InterruptedException
{
	Thread.sleep(3000);
	head.click();
	Thread.sleep(3000);
	snout.click();
}
}
