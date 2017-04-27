package uptakeTests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.UptakeContactPage;
import pages.UptakeHomePage;

public class TestUptakeHomePage {

	private static String browserUrl = "https://uptake.com/";
	private static String browserPath = "C:/Users/Manish/Downloads/selenium/chromedriver.exe"; // setting path to the chrome driver
	private static WebDriver driver = null;
	static UptakeHomePage homePage;
	static UptakeContactPage contactPage;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", browserPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(browserUrl);
		homePage = new UptakeHomePage(driver);
		contactPage = new UptakeContactPage(driver);
		verifyUptakePage(driver);
		driver.quit();

	}// end main method

	public static void verifyUptakePage(WebDriver driver) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(".//*[@id='home']/div[1]/div/div[1]/div/div[1]")));

		String homePageText = homePage.getHomePageText();
		System.out.println("Home Page Text = " + homePageText); // printing the homepage text to the console.

		// assert the text on home age of Uptake
		Assert.assertEquals("Let's put your data to work", homePageText);

		// click on the contact page
		homePage.clickContactButton(); // click on contact

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("contact__form__title")));
		Assert.assertEquals("Get in Touch", contactPage.getcontactPageText());
		contactPage.setFirstName("Manish");
		contactPage.setLastName("Patel");
		contactPage.setCompany("My Company");
		contactPage.setEmail("manish@gmail.com");
		contactPage.setPhone("123-456-7890");
		contactPage.click_potential_interest_picklist_dropdown();
		contactPage.clickPickList();
		contactPage.setTextArea("This is the POM exercise for Uptake");

		/**
		 * click on the Contact Us button to submit the form // commenting the
		 * line below, coz we don't want to click on the contact // us button
		 * right now.
		 */
//		contactPage.clickContactUsButton();
		
		/**
		 * // adding sleep so we can see all the details on contact us page
		 */
		Thread.sleep(4000);

	}// end verifyUptakePage method

}// end Uptake class
