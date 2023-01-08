package com.asb.actitime.pageclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TasksPage {
	public void ClickOnTasks(WebDriver driver) throws InterruptedException {
		driver.findElement(By.id("container_tasks")).click();
		Thread.sleep(1000);
	}
	public void ClickOnAddNew(WebDriver driver) {
		driver.findElement(By.xpath("//div[text()='Add New']")).click();
	}

}
