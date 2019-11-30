package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

	WebDriver driver;
	public ForgotPasswordPage(WebDriver driver)
	{
		this.driver=driver;
	}
	private By Email=By.xpath("//input[@id='email']");
	private By RetrievePassword=By.xpath("//button[@id='form_submit']");
	
	public void enterEmail(String email)
	{
		driver.findElement(Email).sendKeys(email);
	}
	public EmailSentPage clickRetrieve()
	{
		driver.findElement(RetrievePassword).click();
		return new EmailSentPage(driver);
	}
}
