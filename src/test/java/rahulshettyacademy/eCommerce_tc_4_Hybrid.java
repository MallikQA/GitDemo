package rahulshettyacademy;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class eCommerce_tc_4_Hybrid extends BaseTest{
	
	@Test
	public void FillForm() throws InterruptedException
	{
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Sanvidhya");
		//driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Angola']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(3000);
		
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(2000);
		
		List<MobileElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		int count = productPrices.size();
		double totalSum = 0;
		for(int i=0; i<count; i++)
		{
			String amountString = productPrices.get(i).getText();
			Double price = getFormattedAmount(amountString);
			totalSum = totalSum + price;
		}
		String displaySum = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		
		Double displayFormattedSum = getFormattedAmount(displaySum);

		Assert.assertEquals(totalSum, displayFormattedSum);
		
		WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		longPressAction(ele);
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(By.className("android.widget.CheckBox")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(10000);
		//we need to ask/get all the active contexts:native/web and storing them.
		Set<String> contexts = driver.getContextHandles();
		//below is enhance for loop, it iterates till all the contexts just like normal loop
		for(String contextName:contexts)
		{
			System.out.println(contextName);
		}
		//switching to the specific context
		driver.context("WEBVIEW_com.androidsample.generalstore");
		Thread.sleep(6000);
		driver.findElement(By.name("q")).sendKeys("fdsfsdfdsfs");
	
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		//driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");
		
			}

}
