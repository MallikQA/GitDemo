package rahulshettyacademy;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.os.CommandLine;


public class MiscellaneousAppiumActions extends BaseTest {
		
	@Test
	
	public void Miscellaneous() throws MalformedURLException
	
	{
		
		//Activity activity = new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies"); 
		//driver.startActivity(activity);
		//ConfigureAppium(); //commented because we put this in BeforeClass annotation
		driver.findElement(By.xpath("//android.widget.TextView[@text='Preference']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='3. Preference dependencies']")).click();
		
		DeviceRotation landScape = new DeviceRotation(0, 0, 90); // we created an object landscape
		driver.rotate(landScape); //rotate is a method in Appium
		driver.findElement(By.xpath("//android.widget.CheckBox[@index='0']")).click();
		
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='WiFi settings']")).click();
		
		
		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle,"WiFi settings");
		
		//code is correct but not working. below is like copy of text. now the text available in the clipboard
		//driver.setClipboardText("Rahul wifi");
		
		//below is pasting of text from clipboard
		//driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		
		driver.findElement(By.id("android:id/edit")).sendKeys("Rahul wifi");
		//driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.findElements(By.className("android.widget.Button")).get(1).click();
		//driver.pressKey(new KeyEvent(AndroidKey.BACK));
		//driver.pressKey(new KeyEvent(AndroidKey.HOME));
		
		//TearDown(); //commented because we put this in AfterClass annotation


	}

}
