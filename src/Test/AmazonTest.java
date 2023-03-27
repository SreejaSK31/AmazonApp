package Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		WebElement SearchBox = driver.findElement(By.id("twotabsearchtextbox"));
		SearchBox.sendKeys("samsung mobile");

		WebElement Search = driver.findElement(By.id("nav-search-submit-button"));
		Search.click();


   List<WebElement> product_names = driver.findElements(By.xpath("//div[@class='a-section']//h2//span"));
		
		List<WebElement> product_price = driver.findElements(By.xpath("//div[@class='a-section']//a//span[@class='a-price-whole']"));
		
		List<WebElement> rupees = driver.findElements(By.xpath("//div[@class='sg-row']//span[@class='a-price-symbol']"));
		
		System.out.println("result are" +product_names.size() +product_price.size());
		for(int i=0;i<product_names.size();i++)
		{
				System.out.println("Product : " + product_names.get(i).getText());
				System.out.println("Price : "+rupees.get(i).getText() + " " +product_price.get(i).getText());
		}
	}
}

//div[@class='sg-row']/following::span[@class='a-price-symbol'][1]