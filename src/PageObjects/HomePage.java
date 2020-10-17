package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage {
	
	public  WebDriver driver;
	
	By contactusButton=By.cssSelector("body.push-body:nth-child(2) header.index5:nth-child(2) div.affix div.container div.row div.col-md-12 nav.navbar.navbar-default div.navbar-collapse.collapse.navbar-right ul.nav.navbar-nav > li.active:nth-child(5)");
	By joinTeam=By.cssSelector("body.push-body:nth-child(2) header.index5:nth-child(2) div.affix div.container div.row div.col-md-12 nav.navbar.navbar-default div.navbar-collapse.collapse.navbar-right ul.nav.navbar-nav > li:nth-child(4)");
	By About= By.cssSelector("body.push-body:nth-child(2) header.index5:nth-child(2) div.affix div.container div.row div.col-md-12 nav.navbar.navbar-default div.navbar-collapse.collapse.navbar-right ul.nav.navbar-nav > li.active:nth-child(3)");
	
	By AboutSection= By.cssSelector("body.push-body:nth-child(2) section.section-padding:nth-child(4) > div.container");
	By ContactForm = By.cssSelector("body.push-body:nth-child(2) section.info-section:nth-child(8) div.row div.col-md-6.block.light.text-center.wow.fadeInRightBig.animated:nth-child(2) > div.center");
	By  contactusSubmitButton= By.id("btn_submit");
	
	By services=By.cssSelector("body.push-body:nth-child(2) section.section-padding:nth-child(4) > div.container");
	
	
	
	
	
	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}




	
	public WebElement getAboutButton()
	{
		return driver.findElement(About);
	}

	public WebElement getContactUsSubmitButton()
	{
		return driver.findElement(contactusSubmitButton);
}
	

public WebElement getJoinTeamButton()
{
	return driver.findElement(joinTeam);
}


public WebElement AboutSection()
{
	return driver.findElement(AboutSection);
}

public WebElement ContactUsForm()
{
	return driver.findElement(ContactForm);
}

public WebElement ServicesRendered()
{
	return driver.findElement(services);
}

public WebElement getContactusButton()
{
	return driver.findElement(contactusButton);
}



}
