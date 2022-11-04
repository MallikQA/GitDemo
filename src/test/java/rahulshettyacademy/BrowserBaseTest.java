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

public class BrowserBaseTest {
	
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
		caps.setCapability("browserName", "Chrome");
	
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url,caps);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	
	public Double getFormattedAmount(String amount)
	{
		Double price = Double.parseDouble(amount.substring(1));
		return price;
	}

	@AfterClass
	public void TearDown()
	{
		driver.quit();
		
		service.stop();
	}

}
