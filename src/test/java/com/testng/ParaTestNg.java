package com.testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParaTestNg {
	
static WebDriver driver;
    
    @Parameters({"first","second","address","email"})
    @Test(priority = 0)
    private void tc1(String first,String second,String address,String email) {
    	
        driver = new ChromeDriver();
    	driver.get("https://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
    	driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(first);
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(second);
		driver.findElement(By.xpath("//textarea[@rows='3']")).sendKeys(address);
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);

	}
    
    @Parameters("phone")
    @Test(priority = 5)
    private void tc2(String phone) throws InterruptedException {
		
    	driver.findElement(By.xpath("//input[@type='tel']")).sendKeys(phone);
		driver.findElement(By.name("radiooptions")).click();
		driver.findElement(By.id("checkbox1")).click();
		driver.findElement(By.id("checkbox2")).click();
		WebElement lang = driver.findElement(By.id("msdd"));
		Actions action = new Actions(driver);
		action.moveToElement(lang).perform();
		
	}
    
    @Parameters({"pass","confirmpass"})
    @Test(priority = 15)
    private void tc3(String pass,String confirmpass) {
		
    	driver.findElement(By.id("firstpassword")).sendKeys(pass);
		driver.findElement(By.id("secondpassword")).sendKeys(confirmpass);

	}
    
    @Test(priority = 10)
    private void tc4() {
    	WebElement findElement = driver.findElement(By.id("Skills"));
		Select s = new Select(findElement);
		s.selectByIndex(10);
		WebElement findElement2 = driver.findElement(By.id("country"));
		Select s1 = new Select(findElement2);
		s1.selectByValue("India");
		WebElement findElement3 = driver.findElement(By.id("yearbox"));
		Select s2 = new Select(findElement3);
		s2.selectByIndex(5);
//		Thread.sleep(1000);
		WebElement findElement4 = driver.findElement(By.xpath("//select[@placeholder='Month']"));
		Select s3 = new Select(findElement4);
		s3.selectByIndex(4);
//		Thread.sleep(1000);
		WebElement findElement5 = driver.findElement(By.id("daybox"));
		Select s4 = new Select(findElement5);
		s4.selectByIndex(22);

	}

}
