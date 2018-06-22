package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class tatoc {

	public static void main(String args[]) {
		WebDriver driver = new ChromeDriver();
		System.out.println("User is opening google");
		driver.get("http://10.0.1.86/tatoc");
		
	}
}
