package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.WindowNavigator;

public class MultiplePage {

	WebDriver driver;
	private By clickHere=By.xpath("//a[contains(text(),'Click Here')]");
	public MultiplePage(WebDriver driver) {
		this.driver=driver;
	}
	public WindowNavigator clickhere()
	{
		driver.findElement(clickHere).click();
		return new WindowNavigator(driver);
				
	}
	
}
