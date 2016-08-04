package sirsidynix.sirsidynix;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class App {

	public static void main(String[] args) throws InterruptedException {
		
// Set the sirsidynix web page in the variable urlSirsidynix 
		String urlSirsidynix = "http://www.sirsidynix.com/";
		

// Chrome execution
// Search the absolute path of chromedriver and
		String exePath = new File("files\\chromedriver.exe").getAbsolutePath();
		
// Check the absolute path of chromedriver
		System.out.println("absolute path is " + exePath);

// Set "webdriver.chrome.driver" on chromedriver
		System.setProperty("webdriver.chrome.driver", exePath);
		
// Set driver as instance of Chromedriver
		WebDriver driver = new ChromeDriver();
		
// Open Browser with the sirsidynix URL
		driver.get(urlSirsidynix);

// Search the object "search_block_form" and write "cosugi 2016"
		driver.findElement(By.name("search_block_form")).sendKeys("cosugi 2016");
		
// Click on search button (magnifying glass icon)
		driver.findElement(By.name("submit")).click();
		
// Set wait as Webdriverwait instance, with 40 seconds timeout
		WebDriverWait wait = new WebDriverWait(driver, 40);

// Wait for "Search page results"
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search-page-results")));
		
// Click on second search item
		driver.findElement(By.xpath("//*[@id='search-page-results']/ol/li[2]/h3/a")).click();
		
// Wait for title "Your COSUGI Compendium: Everything You Need to Know About Indianapolis, part 2 The Dish on Dining"
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("page-title"),"Your COSUGI Compendium: Everything You Need to Know About Indianapolis, part 2 The Dish on Dining"));

// Check if the url match with "http://www.sirsidynix.com/blog/2016/05/09/your-cosugi-compendium-everything-you-need-to-know-about" 
// and print the result in log
		if (driver.getCurrentUrl().equalsIgnoreCase("http://www.sirsidynix.com/blog/2016/05/09/your-cosugi-compendium-everything-you-need-to-know-about")){
			System.out.println("Requested URL is the same as the one found");
		} else {
			System.out.println("Requested URL is different from the one found");
		}
		
	}
}