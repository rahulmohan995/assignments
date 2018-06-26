package com.qainfotech.tatocmaven;

import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class App {
	
	WebDriver driver= new ChromeDriver();
	
	public String CurrentLink() {
		return driver.getCurrentUrl();
	}
	
	public void ChooseBasicCourse() {
		driver.get("http://10.0.1.86/tatoc");
		driver.findElement(By.linkText("Basic Course")).click();
	}
	
	public void gridgate() {
		driver.findElement(By.className("greenbox")).click();
	}
	
	public void framedungeon() {
		driver.switchTo().frame("main");
		String box1=driver.findElement(By.id("answer")).getAttribute("className"), box2;
		while(true)
		{
			driver.switchTo().frame("child");
			box2=driver.findElement(By.id("answer")).getAttribute("className");
			if(box1.equalsIgnoreCase(box2))
			{
				driver.switchTo().parentFrame();
				driver.findElement(By.linkText("Proceed")).click();
				break;
			}
			driver.switchTo().parentFrame();
			driver.findElement(By.linkText("Repaint Box 2")).click();
		}
	}
	
	public void basicdrag() {
		Actions action = new Actions(driver);
		WebElement drag = driver.findElement(By.id("dragbox"));
		WebElement drop = driver.findElement(By.id("dropbox"));
		action.dragAndDrop(drag, drop).build().perform();
		driver.findElement(By.linkText("Proceed")).click();
	}
	
	public void windows() {
		driver.findElement(By.linkText("Launch Popup Window")).click();
		String Window1=driver.getWindowHandle();
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		while(it.hasNext())
		{
			String Window2=it.next();
			driver.switchTo().window(Window2);
			if(!Window1.equalsIgnoreCase(Window2))
			{
				driver.findElement(By.id("name")).sendKeys("Rahul");
				driver.findElement(By.id("submit")).click();
				break;
			}
		}
		driver.switchTo().window(Window1);
		driver.findElement(By.linkText("Proceed")).click();
		
	}
	
	public void cookie() {
		driver.findElement(By.linkText("Generate Token")).click();
		String Cookievalue=driver.findElement(By.id("token")).getText();
		Cookie cookie=new Cookie("Token", Cookievalue.substring(7));
		driver.manage().addCookie(cookie);
		driver.findElement(By.linkText("Proceed")).click();
	}

}
