package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmailSentPage {

	WebDriver driver;
	private By msg=By.xpath("//div[@id='content']");
	public EmailSentPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public String validateMsg()
	{
		String msg1=driver.findElement(msg).getText();
		return msg1;
	}
	
}
