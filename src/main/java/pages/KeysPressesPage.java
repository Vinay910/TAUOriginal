package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class KeysPressesPage {
	
	private WebDriver driver;
	private By keyTextBox=By.xpath("//input[@id='target']");
	private By keyResult=By.xpath("//p[@id='result']");
	public KeysPressesPage(WebDriver driver) {
		this.driver=driver;
	}
	public String enterTextAndVerify(String value)
	{
		driver.findElement(keyTextBox).sendKeys(value);
		return driver.findElement(keyResult).getText();
	}
	
}
