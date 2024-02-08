package intTestObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUsPage {

	WebDriver driver;
	
	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
	
	}
	By firstName = By.cssSelector("#form-input-fullName");
	By organisationName = By.cssSelector("#form-input-organisationName");
	By mobileNumber = By.cssSelector("#form-input-cellPhone");
	By contactBtn = By.xpath("(//div[@class='text-center']/div/button[text()='Contact'])[1]");
	By email = By.cssSelector("#form-input-email");
	By jobRole = By.cssSelector("#form-input-jobRole");
	By message = By.cssSelector("#form-input-message");
	By consentRadioBtn = By.cssSelector("#form-input-consentAgreed-0");
	By jobRoleDrpdwn = By.xpath("//select[@id='form-input-jobRole']");
	By textOptions = By.xpath("//select[@id='form-input-jobRole']/option");
	By SubmitBtn = By.xpath(" (//button[text()='Submit'])[1]");
	By errorMessage = By.xpath("//div[@class='ff-form-errors']");
	

	public void enterFormDetails() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(contactBtn).click();
		Thread.sleep(4000);
		driver.findElement(firstName).sendKeys("Test");
		driver.findElement(email).sendKeys("xyz@gmail.com");
		selectJobRole();
		driver.findElement(mobileNumber).sendKeys("9004962149");
		driver.findElement(organisationName).sendKeys("Google");
		driver.findElement(consentRadioBtn).click();
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(SubmitBtn)).click().build().perform();
		driver.findElement(SubmitBtn).click();
		System.out.println("Submit Button Is Clicked");
		Thread.sleep(10000);

	}

	public void selectJobRole() {
		List<WebElement> list = driver.findElements(textOptions);
		for (int i = 0; i < list.size(); i++) {
			
			Select element = new Select(driver.findElement(jobRoleDrpdwn));
            element.selectByVisibleText("Management");
            }            
		}
		
	
	public void waitForElementToBeVisible(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(9));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

	public String validateErrorMessage() throws InterruptedException {
		Thread.sleep(4000);
		waitForElementToBeVisible(driver.findElement(errorMessage));
		String message = driver.findElement(errorMessage).getText();
		return message;
}
	}
	
