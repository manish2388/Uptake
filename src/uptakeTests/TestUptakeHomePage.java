package uptakeTests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUptakeHomePage {

	private static String browserUrl = "https://uptake.com/";
	private static String browserPath = "C:/Users/Manish/Downloads/selenium/chromedriver.exe";
	private static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", browserPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(browserUrl);
		verifyUptakePage(driver);
		driver.quit();

	}// end main method

	public static void verifyUptakePage(WebDriver driver) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(".//*[@id='home']/div[1]/div/div[1]/div/div[1]")));
		String homePageText = driver.findElement(By.xpath(".//*[@id='home']/div[1]/div/div[1]/div/div[1]")).getText();
		System.out.println("Home Page Text = " + homePageText);

		// assert the text on home age of Uptake
		Assert.assertEquals("Let's put your data to work", homePageText);

		driver.findElement(By.xpath(".//*[@id='footer']/div[1]/div[2]/button")).click(); // click
																							// on
																							// contact
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("contact__form__title")));
		Assert.assertEquals("Get in Touch", driver.findElement(By.className("contact__form__title")).getText());
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Manish");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Patel");
		driver.findElement(By.xpath("//input[@name='company']")).sendKeys("My Company");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("manish@gmail.com");
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("123-456-7890");
		driver.findElement(By.xpath("//select[@name='potential_interest_picklist']")).click();
		driver.findElement(By.xpath("//option[@value='A Career with Uptake']")).click();
		driver.findElement(By.xpath("//textarea[@name='lead_description__c']"))
				.sendKeys("This is the POM exercise for Uptake");

		/**
		 * click on the Contact Us button to submit the form // commenting the
		 * line below, coz we don't want to click on the contact // us button
		 * right now.
		 */
		// driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(4000);

	}// end verifyUptakePage method

}// end Uptake class
