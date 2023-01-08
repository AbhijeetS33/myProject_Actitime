package com.asb.actitime.users;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.asb.actitime.testbase.BaseClass;

public class deleteUser extends BaseClass {
	@Test
	public void testDeleteUser() throws InterruptedException {
		up.ClickOnUsers(driver);
		int lastRow= xlib.getLastRowNumber("DeleteUser");
		for(int i=1;i<=lastRow;i++) {
		String firstName = xlib.getExcelData("DeleteUser", i, 0);
		String middleName = xlib.getExcelData("DeleteUser", i, 1);
		String lastName = xlib.getExcelData("DeleteUser", i, 2);
		driver.findElement(By.xpath("//span[@id='ext-gen580']/../../../../../../../../..//div[@class='icon']")).click();
		driver.findElement(By.xpath(
				"//span[text()='List of Users']/../../../..//div[text()='Users']/../../..//input[@placeholder='Start typing name...']"))
				.sendKeys(lastName + ", " + firstName + " " + middleName);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='userNameSpan']/../../../../../../../../..//div[@class='icon manageUsers']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='" + firstName + " " + middleName + ". " + lastName + "']/..//div[text()='DELETE']")).click();
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
	    driver.navigate().refresh();
		  
		}
	}
}
