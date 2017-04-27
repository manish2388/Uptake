package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UptakeHomePage {

	WebDriver driver;
	By homePageText = By.xpath(".//*[@id='home']/div[1]/div/div[1]/div/div[1]");
	By contactButton = By.xpath(".//*[@id='footer']/div[1]/div[2]/button");

	public WebDriver getDriver() {
		return driver;
	}

	public UptakeHomePage(WebDriver driver) {
		this.driver = driver;
	}

	public String getHomePageText() {
		return driver.findElement(homePageText).getText();
	}

	// click on the contact button
	public void clickContactButton() {
		driver.findElement(contactButton).click();
	}

}
