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


public class SwipeDemo extends BaseTest {
		
	@Test
	
	public void SwipeDemoTest() throws MalformedURLException, InterruptedException
	
	{
				driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
				driver.findElement(By.xpath("//android.widget.TextView[@text='Gallery']")).click();
				driver.findElement(By.xpath("//android.widget.TextView[@text='1. Photos']")).click();
				
				WebElement firstImage = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
				
				//checking whether the first image is focusable. the expectation is True
				Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"),"true");
				
				//Swipe action
				swipeAction(firstImage, "left");
				
				//after swiped, Again checking the first image is focusable. expectation is False.
				Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"),"false");
				
				

}
}

