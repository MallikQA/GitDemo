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


public class ScrollDemo extends BaseTest {
		
	@Test
	
	public void ScrollDemoTest() throws MalformedURLException, InterruptedException
	
	{
				driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
				//the below won't work on sony. we use this when we exactly know prior where to scroll.
				//driver.findElement(AppiumBy.andrdoidUIAutomator("new UIScrollable(new UISelector()).scrollIntoView(text(\"Web view\"));"));
				
				//This code is not working on sony. click function to see the implementation in base test.
				//when we don't know if the item exists, so we scroll and check if it exists.
				//This code using the co-ordinates
				//This keeps scrolling till bottom of the page. we can put codition to check our element is present.
				//it stop if our element is found.
				WebElement ele1 = driver.findElement(By.xpath("//android.widget.TextView[@text='Gallery']"));
						
				((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", 
						ImmutableMap.of(
								"elementId", ((RemoteWebElement)ele1).getId(),
								"direction", "down",
								"percent", 3.0,	// this is scrolling based on the number
								"speed",6000
								
					));
				
				//scrollToEndAction(ele1);

				//"direction", "down",
				//"left" 100, "top", 100, "width", 200, "height", 200,
				
		
		

	}

}
