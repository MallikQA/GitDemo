package rahulshettyacademy;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	
	public AppiumDriver<MobileElement> driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException
	{
		File f = new File("C:\\Users\\user\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
		DesiredCapabilities caps = new DesiredCapabilities();
		
		service = new AppiumServiceBuilder().withAppiumJS(f)
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		//below line is to check with chrome driver when context switched to Hybrid app/webview
		caps.setCapability("chromedriverExecutable", 
				"C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
		caps.setCapability("chromeOptions", ImmutableMap.of("w3c", false));
		caps.setCapability("platformName", "Android");
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("platformVersion", "11.0");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Honor 9 Lite");
		caps.setCapability(MobileCapabilityType.UDID, "S5D3Y18918034914");
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,  60);
		//below are related to the API demos app
		//caps.setCapability("appPackage", "io.appium.android.apis");
		//caps.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		//below are related to the General store ecommerce app
		caps.setCapability("appPackage", "com.androidsample.generalstore");
		caps.setCapability("appActivity", "com.androidsample.generalstore.SplashActivity");
		
		//com.androidsample.generalstore/com.androidsample.generalstore.MainActivity
		//SplashActivity
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		
		driver = new AppiumDriver<MobileElement>(url,caps);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		}
	public void longPressAction(WebElement ele)
	{
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", 
				ImmutableMap.of("elementId", ((RemoteWebElement)ele).getId(),
						"duration",2000));
		
	}
	
	public void swipeAction(WebElement ele, String direction)
	{
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement)ele).getId(),
			    "direction", direction,
			    "percent", 0.75
			));
		
	}
	
	public double getFormattedAmount(String amount)
	{
		double price = Double.parseDouble(amount.substring(1));
		return price;

		
		
	}
	
//	public void scrollToEndAction(WebElement ele1)
//	{
//		boolean canScrollMore;
//		do
//		{
//
//		canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", 
//				ImmutableMap.of(
//						"elementId", ((RemoteWebElement)ele1).getId(),
//						"direction", "down",
//						"percent", 3.0	
//						
//			));
//		} while(canScrollMore);
//	}
		
	
	@AfterClass
	public void TearDown()
	{
		driver.quit();
		
		service.stop();
	}

}
