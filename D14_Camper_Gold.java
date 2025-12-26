package WebDriver_Project;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class D14_Camper_Gold {

	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://sampleapp.tricentis.com/101/index.php");

		driver.findElement(By.id("nav_camper")).click();
		//Enter Vehical Data
		driver.findElement(By.id("entervehicledata"));
		new Select(driver.findElement(By.id("make"))).selectByVisibleText("Honda");
		
		driver.findElement(By.id("engineperformance")).sendKeys("550");
		driver.findElement(By.id("dateofmanufacture")).sendKeys("02/11/2025");
		new Select(driver.findElement(By.id("numberofseats"))).selectByVisibleText("3");
		driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[1]/div[5]/p/label[1]/span")).click();
		new Select(driver.findElement(By.id("fuel"))).selectByVisibleText("Petrol");
		driver.findElement(By.id("payload")).sendKeys("750");
		driver.findElement(By.id("totalweight")).sendKeys("4000");
		driver.findElement(By.id("listprice")).sendKeys("1000");
		driver.findElement(By.id("licenseplatenumber")).sendKeys("MH09H3032");
		driver.findElement(By.id("annualmileage")).sendKeys("1800");
		driver.findElement(By.id("nextenterinsurantdata")).click();

		//ENTER INSURANT DATA	
		driver.findElement(By.id("firstname")).sendKeys("Gaurav");
		driver.findElement(By.id("lastname")).sendKeys("Bhatale");
		driver.findElement(By.id("birthdate")).sendKeys("08/04/1999");
		driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[2]/div[4]/p/label[1]/span")).click();
		driver.findElement(By.id("streetaddress")).sendKeys("Kolhapur,Mharastra,India");
		new Select (driver.findElement(By.id("country"))).selectByVisibleText("India");
		driver.findElement(By.id("zipcode")).sendKeys("1011");
		driver.findElement(By.id("city")).sendKeys("Kolhapur");
		new Select(driver.findElement(By.id("occupation"))).selectByVisibleText("Unemployed");

		driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[2]/div[10]/p/label[1]/span")).click();    //  im stuck
		driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[2]/div[10]/p/label[4]/span")).click(); // Not solved

		driver.findElement(By.id("website")).sendKeys("Flipkart.com");

		Robot rbt = new Robot();
		driver.findElement(By.id("open")).click();
		for(int i=1; i<10; i++)
		{
			Thread.sleep(500);
			rbt.keyPress(KeyEvent.VK_TAB); //Will Press Tab Key
		}
		for(int i=1; i<5;i++)
		{
			Thread.sleep(500)
			;
			rbt.keyPress(KeyEvent.VK_DOWN);  // Will press Down Arrow Key
		}
		Thread.sleep(500);
		rbt.keyPress(KeyEvent.VK_ENTER);

		Thread.sleep(500);
		rbt.keyPress(KeyEvent.VK_TAB);

		for(int i=1; i<4; i++)
		{
			Thread.sleep(500);
			rbt.keyPress(KeyEvent.VK_DOWN); 
		}
		Thread.sleep(500);
		rbt.keyPress(KeyEvent.VK_ENTER);

		driver.findElement(By.id("nextenterproductdata")).click();

		//ENTER PRODUCT DATA
		Thread.sleep(500);
		driver.findElement(By.id("startdate")).sendKeys("03/18/2028");
		Thread.sleep(100);
		new Select(driver.findElement(By.id("insurancesum"))).selectByVisibleText("  10.000.000,00");
		new Select(driver.findElement(By.id("damageinsurance"))).selectByVisibleText("No Coverage");
		driver.findElement(By.xpath("//*[@id=\"insurance-form\"]/div/section[3]/div[4]/p/label[1]/span")).click(); 
		driver.findElement(By.id("nextselectpriceoption")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"selectpriceoption\"]")).click();

		//SELECT PRICE OPTION
		String expPrice = "293.00" ,expClaim = "No", expDis = "No",expCover = "No",actPrice,actClaim,actDis,actCover;
		
		actPrice = driver.findElement(By.id("selectgold_price")).getText();
		actClaim = driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tbody/tr[2]/td[3]")).getText();
		actDis = driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tbody/tr[3]/td[3]")).getText();
		actCover = driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tbody/tr[4]/td[3]")).getText();

		System.out.println("Clicking Camper - Gold Values");

		if(actPrice.equals(expPrice))
			System.out.println("Price Matching...");
		else
			System.out.println("Price NOT matching");
		if(actClaim.equals(expClaim))
			System.out.println("Online CLaim Matching Matching...");
		else
			System.out.println("Online Claim NOT matching");
		if(actDis.equals(expDis))
			System.out.println("Claims Discount Matching...");
		else
			System.out.println("Claim Discount NOT matching");
		if(actCover.equals(expCover))
			System.out.println("Online Cover Matching...");
		else
			System.out.println("Online Cover NOT matching");
		
		driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tfoot/tr/th[2]/label[2]/span")).click();
		driver.findElement(By.id("nextsendquote")).click();
		//SEND QUOTE
		driver.findElement(By.id("email")).sendKeys("gaurav11@gmail.com");
		driver.findElement(By.id("phone")).sendKeys("5252285494");
		driver.findElement(By.id("username")).sendKeys("Gaurav");
		driver.findElement(By.id("password")).sendKeys("Gauru4321");
		driver.findElement(By.id("confirmpassword")).sendKeys("Gauru4321");
		driver.findElement(By.id("Comments")).sendKeys("No Comments");
		driver.findElement(By.id("sendemail")).click();
		System.out.println(driver.findElement(By.xpath("/html/body/div[4]/h2")).getText());
		Thread.sleep(500);
		driver.findElement(By.xpath("/html/body/div[4]/div[7]/div/button")).click();
		//driver.findElement(By.id("backmain")).click();
	}
	

}
