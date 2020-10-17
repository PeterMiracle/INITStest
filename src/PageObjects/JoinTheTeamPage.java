package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JoinTheTeamPage {
	public  WebDriver driver;

	By 	Jointeam = By.cssSelector("body.push-body:nth-child(2) section.section-padding:nth-child(3) > div.container.job_roles:nth-child(1)");
	
	
	
	
	
	public JoinTheTeamPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}




	public WebElement WanttoJoin()
	{
		return driver.findElement(Jointeam);
	}
	
	
}
