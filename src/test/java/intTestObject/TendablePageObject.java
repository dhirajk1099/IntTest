package intTestObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TendablePageObject {

	WebDriver driver;
	
	public TendablePageObject(WebDriver driver) {
		this.driver = driver;
	}
	

	By ourStoryText = By.xpath("//a[contains(text(),'Our Story')]");
	By ourSolutionText = By.xpath("//a[contains(text(),'Our Solution')]");
	By whyTendableText = By.xpath("//a[contains(text(),'Why Tendable?')]");
	By aboutUsText = By.xpath("//a[contains(text(),'About Us')]");


	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

}
