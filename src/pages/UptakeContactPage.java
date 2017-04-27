package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UptakeContactPage {
	WebDriver driver;
	By contactPageText = By.className("contact__form__title");
	By firstName = By.xpath("//input[@name='firstname']");
	By lastName = By.xpath("//input[@name='lastname']");
	By company = By.xpath("//input[@name='company']");
	By email = By.xpath("//input[@name='email']");
	By phone = By.xpath("//input[@name='phone']");
	By potential_interest_picklist = By.xpath("//select[@name='potential_interest_picklist']");
	By pickList = By.xpath("//option[@value='A Career with Uptake']");
	By textArea = By.xpath("//textarea[@name='lead_description__c']");
	By submitBtn = By.xpath("//input[@type='submit']");

	public UptakeContactPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getcontactPageText() {
		return driver.findElement(contactPageText).getText();
	}

	public void setFirstName(String fName) {
		driver.findElement(firstName).sendKeys(fName);
	}

	public void setLastName(String lName) {
		driver.findElement(lastName).sendKeys(lName);
	}

	public void setCompany(String cName) {
		driver.findElement(company).sendKeys(cName);
	}

	public void setEmail(String emailString) {
		driver.findElement(email).sendKeys(emailString);
	}

	public void setPhone(String phoneNum) {
		driver.findElement(phone).sendKeys(phoneNum);
	}

	public void click_potential_interest_picklist_dropdown() {
		driver.findElement(potential_interest_picklist).click();
	}

	public void clickPickList() {
		driver.findElement(pickList).click();
	}

	public void setTextArea(String textAreaString) {
		driver.findElement(textArea).sendKeys(textAreaString);
	}

	public void clickContactUsButton() {
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}
}// end UptakeContactPage class
