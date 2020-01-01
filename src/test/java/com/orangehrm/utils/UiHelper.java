package com.orangehrm.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UiHelper {
	public static WebDriver  _driver;
	private Properties _prop;
	public WebDriverWait _wait;
	public UiHelper(){
		if(_driver == null){
			try {
				_prop = new Properties();
				FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/test/java/com/orangehrm"
						+ "/config/config.properties");
				_prop.load(ip);
				initialization();
				_wait= new WebDriverWait(_driver,20);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
			}
	public  void initialization() {
		String browserName = _prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "/drivers/chromedriver.exe");	
			_driver = new ChromeDriver(); 
		}
		else if(browserName.equals("FF"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver");	
			_driver = new FirefoxDriver(); 
		} 
		_driver.manage().deleteAllCookies();
		_driver.manage().window().maximize();
		_driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		_driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
	}
	
	public WebDriver getDriver()
	{
		return _driver;
	}
	
	public String getOrangeHrmUrl()
	{
		System.out.println("The url is"+_prop.getProperty("url"));
		return _prop.getProperty("url");
	}
	
	public void waitUntilElementToBeClickable(By by)
	{
		_wait.until(ExpectedConditions.elementToBeClickable(by));
	}
	
	public WebElement getElementBy(By by)
	{
		return _driver.findElement(by);
	}
	
	public void clickWaitUntilElementClickable(By by)
	{
		WebElement element = getElementBy(by);
		waitUntilElementToBeClickable(by);
		element.click();
	}
	public void waitUntilElementVisible(By by){
		_wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	public void sendKeys(By by, String input)
	{
		waitUntilElementVisible(by);
		getElementBy(by).sendKeys(input);
	}
	public void get(String url) 
	{
		_driver.get(url);
	}
	
	public String getTitle()
	{
		return _driver.getTitle();
	}
	
	public String getCurrentUrl()
	{
		return _driver.getCurrentUrl();
	}
	
	public void refreshPage()
	{
		_driver.navigate().refresh();
	}
	
	public void close()
	{
		_driver.close();
	}
	public void quitDriver()
	{
		_driver.quit();
	}
}