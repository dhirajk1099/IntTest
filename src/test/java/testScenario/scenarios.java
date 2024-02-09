package testScenario;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import intTestObject.ContactUsPage;
import intTestObject.HomePageObject;
import intTestObject.OurSolutionPage;
import intTestObject.TendablePageObject;
import io.github.bonigarcia.wdm.WebDriverManager;

public class scenarios {
	WebDriver driver;

	HomePageObject hmp;
	OurSolutionPage osp;
	ContactUsPage cup;
	TendablePageObject tpo;

	@BeforeTest
	public HomePageObject beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.tendable.com/");
		driver.manage().window().maximize();
		hmp = new HomePageObject(driver);
		return new HomePageObject(driver);
	}

	 @Test
	public void verifyTest() throws InterruptedException {
		// hmp = new HomePageObject(driver);
		String url = hmp.verifyOurStoryLink();
		Thread.sleep(3000);
		Assert.assertEquals(url, "https://www.tendable.com/our-story");
		boolean value = hmp.verifyRequestDemo();
		Assert.assertTrue(value);
		osp = hmp.solutionClick();
		Assert.assertEquals(osp.getUrl(), "https://www.tendable.com/our-solution");
		Assert.assertTrue(hmp.verifyRequestDemo());
		tpo = hmp.tendableClick();
		Assert.assertTrue(tpo.getCurrentUrl().equalsIgnoreCase("https://www.tendable.com/why-tendable"));
		Assert.assertTrue(hmp.verifyRequestDemo());


	}

	@Test
	public void verifyContactUsPage() throws InterruptedException {
		cup = hmp.contactUsClick();
		cup.enterFormDetails();
		Assert.assertEquals(cup.validateErrorMessage(),
				"Sorry, there was an error submitting the form. Please try again.");
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
