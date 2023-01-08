package com.asb.actitime.users;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.asb.actitime.testbase.BaseClass;

public class createUser extends BaseClass{
  @Test
  public void testCreateUser() throws InterruptedException {
	  up.ClickOnUsers(driver);
	  int lastRow= xlib.getLastRowNumber("CreateUser");
	  for(int i=1;i<=lastRow;i++) {
	  driver.findElement(By.xpath("//div[text()='New User']")).click();
	  Thread.sleep(2000);
	  
	  String firstName= xlib.getExcelData("CreateUser", i, 0);
	  String middleName= xlib.getExcelData("CreateUser", i, 1);
	  String lastName= xlib.getExcelData("CreateUser", i, 2);
	  String emailID= xlib.getExcelData("CreateUser", i, 3);
	  
	  driver.findElement(By.id("createUserPanel_firstNameField")).sendKeys(firstName);
	  driver.findElement(By.id("createUserPanel_middleNameField")).sendKeys(middleName);
	  driver.findElement(By.id("createUserPanel_lastNameField")).sendKeys(lastName);
	  driver.findElement(By.id("createUserPanel_emailField")).sendKeys(emailID);
	  driver.findElement(By.xpath("//div[text()='-- department not assigned --' and @class='title']")).click();
	  driver.findElement(By.xpath("//div[text()='Account Information']/..//div[text()='Top Management']")).click();
	  driver.findElement(By.xpath("//div[text()='Save & Send Invitation']")).click();
	  driver.findElement(By.xpath("//span[text()='Invite one more user']/../..//span[text()='Close']")).click();
	  Thread.sleep(3000);
	  driver.navigate().refresh();
	  
	  }
   }
}
