package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccessLoginPage{

	private WebDriver driver;
	private By successMessage=By.xpath("//div[@id='flash']");
	public SuccessLoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public String validateSuccess()
	{
		String msg=driver.findElement(successMessage).getText();
		return msg;
	}
}
