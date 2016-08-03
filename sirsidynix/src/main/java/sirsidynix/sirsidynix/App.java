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
		
		String urlSirsidynix = "http://www.sirsidynix.com/";
		
//		Ejeccion con Firefox
//		Quitar comentario en caso de ejecutar con Firefox
//		WebDriver driver = new FirefoxDriver();
		
//		Ejecucion con Chrome 
//		Descargar chromedriver.exe de http://chromedriver.storage.googleapis.com/index.html?path=2.22/
//		String exePath = "files\\chromedriver.exe";
		String exePath = new File("files\\chromedriver.exe").getAbsolutePath();
		
		System.out.println(exePath);
//		File f = new File("files\\chromedriver.exe").exists();
//		System.out.println(new File("files\\chromedriver.exe").getAbsolutePath());
		System.setProperty("webdriver.chrome.driver", exePath);
		
		WebDriver driver = new ChromeDriver();
		
		driver.get(urlSirsidynix);
		
		driver.findElement(By.name("search_block_form")).sendKeys("cosugi 2016");
		
		driver.findElement(By.name("submit")).click();
		

		
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("footer_bottom_wrap")));
		
		System.out.println(element);
		
		driver.findElement(By.xpath("//*[@id='search-page-results']/ol/li[2]/h3/a")).click();
		
		Thread.sleep(5000);
		

		String url1 = driver.getCurrentUrl();
		System.out.println(url1);
		

		if (driver.getCurrentUrl().equalsIgnoreCase("http://www.sirsidynix.com/blog/2016/05/09/your-cosugi-compendium-everything-you-need-to-know-about")){
			System.out.println("Requested URL is the same as the one found");
		} else {
			System.out.println("Requested URL is different from the one found");
		}
		
	}
}