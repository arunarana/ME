import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login
{
     public static void main(String[] args) 
     {
    	 System.setProperty("webdriver.chrome.driver","./exefiles/chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 driver.get("https://www.facebook.com/login/");
		 String text = driver.findElement(By.id("loginbutton")).getText();
		 System.out.println(text);
	}
}
