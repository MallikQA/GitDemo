package rahulshettyacademy;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.os.CommandLine;


public class AppiumBasics extends BaseTest {
		
	@Test
	
	public void WifiSettingsName() throws MalformedURLException
	
	{
		//ConfigureAppium(); //commented because we put this in BeforeClass annotation
		driver.findElement(By.xpath("//android.widget.TextView[@text='Preference']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='3. Preference dependencies']")).click();
		driver.findElement(By.xpath("//android.widget.CheckBox[@index='0']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='WiFi settings']")).click();
		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle,"WiFi settings");
		driver.findElement(By.id("android:id/edit")).sendKeys("abcd");
		driver.findElements(By.className("android.widget.Button")).get(1).click();
		

		
		
		
		
		//TearDown(); //commented because we put this in AfterClass annotation


	}

}
