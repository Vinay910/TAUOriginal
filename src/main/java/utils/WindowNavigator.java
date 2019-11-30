package utils;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WindowNavigator {
	WebDriver driver;
	public WindowNavigator(WebDriver driver) {
		this.driver=driver;
	}
	public void goBack()
	{
		driver.navigate().back();
	}
	public void goForward()
	{
		driver.navigate().forward();
	}
	public void goToPage(String value)
	{
		driver.navigate().to(value);
	}
	public void goRefresh()
	{
		driver.navigate().refresh();
	}
	public WindowNavigator switchWindow(String title)
	{
		Set<String> set1=driver.getWindowHandles();
		for(String s:set1)
		{
			if(s.equalsIgnoreCase(title))
			{
				driver.switchTo().window(s);
			}
		}
		return new WindowNavigator(driver);
	}
}
