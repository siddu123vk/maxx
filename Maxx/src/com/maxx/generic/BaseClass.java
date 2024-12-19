package com.maxx.generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.maxx.pom.HomePage;
import com.maxx.pom.LoginPage;
public class BaseClass {
	public static WebDriver driver;
	public static FileLib f=new FileLib();
	@BeforeTest
	public void openBrowser() throws IOException {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String url = f.getPropertyData("url");
		driver.get(url);
	}	@BeforeMethod
	public void login() throws IOException {
String un = f.getPropertyData("un");
String pwd = f.getPropertyData("pwd");
		LoginPage l=new LoginPage(driver);
		l.login(un,pwd);
	}@AfterMethod
	public void logout() {
		HomePage h=new HomePage(driver);
		h.setLogout();
	}@AfterTest
	public void closeBrowser() {
		driver.manage().window().minimize();
		driver.quit();
	}
}
