package tatoc;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions; 	

public class TatocOnChrome {

	public static void main (String args[])
	{
		WebDriver driver= new ChromeDriver();
		driver.get("http://10.0.1.86/tatoc");
		driver.findElement(By.linkText("Basic Course")).click();
		driver.findElement(By.className("greenbox")).click();
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
		Actions action = new Actions(driver);
		WebElement drag = driver.findElement(By.id("dragbox"));
		WebElement drop = driver.findElement(By.id("dropbox"));
		action.dragAndDrop(drag, drop).build().perform();
		driver.findElement(By.linkText("Proceed")).click();
		
		driver.findElement(By.linkText("Launch Popup Window")).click();
		driver.findElement(By.id("name")).sendKeys("abc");
		driver.findElement(By.id("submit")).click();
		
		
	}
}

		