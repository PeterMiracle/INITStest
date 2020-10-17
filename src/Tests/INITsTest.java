package Tests;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObjects.HomePage;
import PageObjects.JoinTheTeamPage;

public class INITsTest {

	public static WebDriver driver;
	public static SoftAssert a = new SoftAssert();
	public static HomePage hp = new HomePage(driver); // page object Model implemented

	@BeforeTest
	public void initializeDriver() {

		System.setProperty("webdriver.chrome.driver", "C:\\INITS\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://initsng.com/v2/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS); // wait
	}

	@Test
	public void ServiceTitlesValidation1() {
		String[] ExpectedTitles = { "Web-based Software Development", "Mobile Apps Development",
				"Identity Management & Verification", "IT Consulting & Advisory", "Data Acquisition",
				"Desktop & Embedded Devices" };
		// create an array for expected service titles

		List<WebElement> titles = hp.ServicesRendered().findElements(By.cssSelector("body.push-body:nth-child(2) section.section-padding:nth-child(4) div.container div.row div.col-md-4.col-sm-4.canvas-box.magin30.text-center.wow.fadeInDown.animated:nth-child(2) > h4.color6:nth-child(2)")); // retreive the element(service
																						// titles)

		List<String> ActualTitles = new ArrayList<String>(); // create a new array list
		for (int i = 0; i < titles.size(); i++) { // iterate and get retrieve texts on the title
			ActualTitles.add(titles.get(i).getText());//// store retieved elements in an array
		}

		Assert.assertEquals(ExpectedTitles, ActualTitles.toArray()); // asserting to compare the newly created list to
																		// compare expected array

		System.out.println("Assertion passed");

	}

	@Test
	public void hyperlinksTest() throws  Exception {
		// Enumerate the number of active hyperlinks on the webpage. Create an assertion
		// for this

		List<WebElement> links = driver.findElements(By.cssSelector("li[class='active'] a")); //get elements with attribute active

		for (WebElement link : links) {
			String url = link.getAttribute("href"); //get href attribute of each link
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection(); //test connection status of each linkclass
			conn.connect(); 
			int respCode = conn.getResponseCode();	//get status/response code of each link	
			System.out.println(respCode);
			a.assertTrue(respCode < 400, "The link with text" + link.getText() + "is active with code" + respCode);

			a.assertAll();
		}

	}

	@Test
	public void ValidateContactForm() throws Exception {

		List<WebElement> nameMessage = driver.findElements(By.id("nameErrorMessage"));
		if (nameMessage.size() > 0) {
			nameMessage.get(0).getText(); 
			Assert.//  validation to check if the message is the one expected
		} else {
			throw new Exception("Warning message was not displayed properly");
		}

	}

	@Test
	public void AboutHyperlink() throws  IOException {
		// Click on the about link verify link is active.click on the link and verify
		// that the appropriate page is displayed,create assertion for each

		

		Assert.assertTrue(hp.getAboutButton().getAttribute("class").contains("active")); // i.get class attribute of
																							// about tab on page
																							// 2.assert if about link
		hp.getAboutButton().click();	//click about button																				// class attribute contains
																							// "active"

		Assert.assertTrue(hp.AboutSection().isDisplayed());
	}

	@Test
	public void TeamHyperlink() {
		// Click on the team link verify link is active.click on the link and verify
		// that the appropriate page is displayed,create assertion for each

		JoinTheTeamPage jt = new JoinTheTeamPage(driver); // call Join team page object class to use its methods

		Assert.assertTrue(hp.getJoinTeamButton().getAttribute("class").contains("active")); // i.get class attribute of
																							// team tab on page
																							// 2.assert if about link
																							// class attribute contains
																							// "active"

		hp.getJoinTeamButton().click();
		Assert.assertTrue(jt.WanttoJoin().isDisplayed()); // Assert if Page with "Want to Join Our Team" header is
															// displayed

	}

	@Test
	public void ContactUsHyperlink1() {
		// Click on the about link verify link is active.click on the link and verify
		// that the appropriate page is displayed,create asssertion for each

		
		
		Assert.assertTrue(hp.getContactusButton().getAttribute("class").contains("active")); // i.get class attribute of
																								// Contact us tab on
																								// page
		hp.getContactusButton().click();	//click contact us button																					// 2.assert if about
																								// link class attribute
																								// contains "active"

		Assert.assertTrue(hp.ContactUsForm().isDisplayed()); // Assert if "contact us" form is displayed
	}

	@AfterTest
	public void Closedriver() {
		driver.close();
	}

}
