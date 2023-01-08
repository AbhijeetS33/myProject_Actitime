package com.asb.actitime.testbase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.asb.actitime.pageclass.TasksPage;
import com.asb.actitime.pageclass.UserPage;

public class BaseClass {
	public ExcelLibrary xlib;
	public WebDriver driver;
	public TasksPage tp;
	public UserPage up; 
  @BeforeClass
  public void OpenBrowser() {
	  System.out.println("Open Browser");
	  xlib= new ExcelLibrary();
	  String browName= xlib.getExcelData("Browser", 1, 0);
	  if(browName.equals("Firefox")) {
		  System.setProperty("webdriver.gecko.driver", "../Actitime/exeFiles/geckodriver.exe");
		  driver= new FirefoxDriver();
	  }else if(browName.equals("Chrome")) {
		  System.setProperty("webdriver.chrome.driver", "../Actitime/exeFiles/chromedriver.exe");
		  driver= new ChromeDriver();
	  }
	  tp= new TasksPage();
	  up= new UserPage();
	  driver.manage().window().maximize();
	  driver.get("https://demo.actitime.com/login.do");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  
	  String actualTitle= "actiTIME - Login";
	  String expectedTitle= driver.getTitle();
	  
	  Assert.assertEquals(actualTitle, expectedTitle);
	  
	  
	  
  }
  @BeforeMethod
  public void Login() {
	  String uname= xlib.getExcelData("Login", 1, 0);
	  String pword= xlib.getExcelData("Login", 1, 1);
	  driver.findElement(By.id("username")).sendKeys(uname);
	  driver.findElement(By.name("pwd")).sendKeys(pword);
	  Actions act= new Actions(driver);
	  act.sendKeys(Keys.ENTER).perform();
	  String actualtext= "Enter Time-Track";
	  String expectedtext= driver.findElement(By.xpath("//td[contains(text(),' Time-')]")).getText();
	  Assert.assertEquals(actualtext, expectedtext);
  }
  @AfterMethod
  public void Logout() throws InterruptedException {
	  Thread.sleep(1000);
	  driver.findElement(By.id("logoutLink")).click();
  }
  @AfterClass
  public void CloseBrowser() {
	  driver.close();
	  System.out.println("Close Browser");
  }
}
