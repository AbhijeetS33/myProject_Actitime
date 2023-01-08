package com.asb.actitime.tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.asb.actitime.testbase.BaseClass;

public class deleteCustomer extends BaseClass {
	@Test
	public void testDeleteCustomer() throws InterruptedException {
		tp.ClickOnTasks(driver);
		int lastRow= xlib.getLastRowNumber("DeleteCustomer");
		for(int i=1;i<=lastRow;i++) {
		String custName = xlib.getExcelData("DeleteCustomer", i, 0);
		driver.findElement(By.xpath("//div[ @class='titleContainer']/../..//input[@placeholder='Start typing name ...']")).sendKeys(custName);
		WebElement name = driver.findElement(By.xpath("//span[text()='" + custName + "' ]"));
		Actions act = new Actions(driver);
		act.moveToElement(name).perform();
		WebElement editBtn = driver.findElement(By.xpath("//span[text()='" + custName + "' ]/../../..//div[@class='editButton']"));
		act.moveToElement(editBtn).perform();
		act.click(editBtn).perform();
		driver.findElement(By.xpath("//div[text()='" + custName + "']/../../..//div[text()='ACTIONS']")).click();
		driver.findElement(By.xpath("//div[text()='" + custName + "']/../../../../..//div[text()='Delete']")).click();
		driver.findElement(By.xpath("//span[text()='Delete permanently']")).click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		  
		}
	}
}
