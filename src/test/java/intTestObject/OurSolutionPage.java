package intTestObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OurSolutionPage {

	WebDriver driver;
	public OurSolutionPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By ourSolutions = By.xpath("//a[text()='Our Solution']");
	
	public String getUrl() {
		return driver.getCurrentUrl();
	}
}
