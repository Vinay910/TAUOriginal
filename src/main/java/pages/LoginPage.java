package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	private By username=By.xpath("//input[@id='username']");
	private By password=By.xpath("//input[@id='password']");
	private By loginButton=By.xpath("//i[@class='fa fa-2x fa-sign-in']");
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void enterCred(String username,String password)
	{
	   driver.findElement(this.username).sendKeys(username);
	   driver.findElement(this.password).sendKeys(password);
	}
	public SuccessLoginPage clickLogin()
	{
		driver.findElement(loginButton).click();
		return new SuccessLoginPage(driver);
	}
}
