package rahulshettyacademy;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.os.CommandLine;


public class LongPress extends BaseTest {
		
	@Test
	
	public void LongPressGesture() throws MalformedURLException, InterruptedException
	
	{
				driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Expandable Lists']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='1. Custom Adapter']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		longPressAction(ele);
		
//		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", 
//				ImmutableMap.of("elementId", ((RemoteWebElement)ele).getId(),
//						"duration",2000));
		
		Thread.sleep(1000); //just to pause for 1 second on the app to see the behavior.
		String menuText = driver.findElement(By.xpath("//android.widget.TextView[@text='Sample menu']")).getText();
		Assert.assertEquals(menuText, "Sample menu");
		Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[@text='Sample menu']")).isDisplayed());
		

	}

}
