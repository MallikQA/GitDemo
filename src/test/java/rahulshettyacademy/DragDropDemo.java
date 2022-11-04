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


public class DragDropDemo extends BaseTest {
		
	@Test
	
	public void DragDropTest() throws MalformedURLException, InterruptedException
	
	{
				driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
				driver.findElement(By.xpath("//android.widget.TextView[@text='Drag and Drop']")).click();
				WebElement source = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
				((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
					    "elementId", ((RemoteWebElement) source).getId(),
					    "endX", 619,
					    "endY", 560,
					    "speed", 1000
					));		
				
				String result = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
				Assert.assertEquals(result, "Dropped!");
}
}

