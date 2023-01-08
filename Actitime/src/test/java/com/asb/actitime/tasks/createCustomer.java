package com.asb.actitime.tasks;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.asb.actitime.testbase.BaseClass;

public class createCustomer extends BaseClass {
  @Test
  public void testCreateCustomer() throws InterruptedException {
	  tp.ClickOnTasks(driver);
	  int lastRow= xlib.getLastRowNumber("CreateCustomer");
	  for(int i=1;i<=lastRow;i++) {
	  tp.ClickOnAddNew(driver);
	  
	  driver.findElement(By.xpath("//div[@class='item createNewCustomer']")).click();
	  
	  String custName= xlib.getExcelData("CreateCustomer", i, 0);
	  String desc= xlib.getExcelData("CreateCustomer", i, 1); 
	  driver.findElement(By.xpath("//span[contains(@id,'gen1_title')]/../../../../../..//input[@placeholder='Enter Customer Name']")).sendKeys(custName);
	  driver.findElement(By.xpath("//textarea[@placeholder='Enter Customer Description']")).sendKeys(desc);
	  driver.findElement(By.xpath("//div[text()='Create Customer']")).click();
	  Thread.sleep(3000);
	  driver.navigate().refresh();
	  
	  }
  }
}
