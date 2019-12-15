package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

	WebDriver driver;
	public ForgotPasswordPage(WebDriver driver)
	{
		this.driver=driver;
	}
	private By emailLocal=By.xpath("//input[@id='email']");
	private By retrievePassword=By.xpath("//button[@id='form_submit']");
	
	public void enterEmail(String email)
	{
		driver.findElement(emailLocal).sendKeys(email);
	}
	public EmailSentPage clickRetrieve()
	{
		driver.findElement(retrievePassword).click();
		return new EmailSentPage(driver);
	}
}
