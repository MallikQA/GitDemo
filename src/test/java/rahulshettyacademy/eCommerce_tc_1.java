package rahulshettyacademy;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class eCommerce_tc_1 extends BaseTest{
	
	@Test
	public void FillForm() throws InterruptedException
	{
		//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Sanvidhya");
		//driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Angola']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(3000);
		String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		Assert.assertEquals(toastMessage, "Please enter your name");
		
		
			

	}
	

}
