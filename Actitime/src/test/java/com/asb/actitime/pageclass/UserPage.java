package com.asb.actitime.pageclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserPage {
	public void ClickOnUsers(WebDriver driver) throws InterruptedException {
		driver.findElement(By.id("container_users")).click();
		Thread.sleep(1000);
	}

}
