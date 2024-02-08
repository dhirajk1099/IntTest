package intTestObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class HomePageObject {

	WebDriver driver;
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	By ourStory = By.xpath("//a[text()='Our Story']");
	By ourSolutions = By.xpath("//a[text()='Our Solution']");
	By whyTendable = By.xpath("//a[text()='Why Tendable?']");
	By requestDemo = By.xpath("//a[text()='Request A Demo']");
	By contactUs = By.xpath("//a[text()='Contact us']");
	By aboutUS = By.xpath("//a[text()='About Us']");
	
	
	public String verifyOurStoryLink() {
		driver.findElement(ourStory).click();
		String url = driver.getCurrentUrl();
		return url;
	}
	
	public boolean verifyRequestDemo() {
	return driver.findElement(requestDemo).isDisplayed();
	}
	
	 public OurSolutionPage solutionClick()
	    {
	        driver.findElement(ourSolutions).click();
	        return new OurSolutionPage(driver);
	    }
	 
	 public ContactUsPage contactUsClick()
	    {	
		 Actions action = new Actions(driver);	
		 action.moveToElement(driver.findElement(aboutUS)).perform();
	        driver.findElement(contactUs).click();
	        System.out.println("Contact us Button is clicked");
	        return  new ContactUsPage(driver);
	    }
}
