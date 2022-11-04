package rahulshettyacademy;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class eCommerce_tc_2 extends BaseTest{
	
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
		//String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		//Assert.assertEquals(toastMessage, "Please enter your name");
		
		
		int productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		
		for(int i =0;i<productCount;i++)
		{
			String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			if(productName.equalsIgnoreCase("Air Jordan 4 Retro"))
			{
				//get(i) used because we need to click on that particular item
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
				
			}
		}
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(3000);
		
		//using Explicit wait. we need to wait until the Cart page fully loads
		//WebDriverWait is a class given by the selenium.
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
//		String lastPageProduct = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
//		Assert.assertEquals(lastPageProduct, "Air Jordan 4 Retro");
		
			}

}
