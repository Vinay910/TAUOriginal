package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage {
	
	WebDriver driver;
	private By hiddenLink=By.xpath("//a[contains(text(),'Example 1: Element on page that is hidden')]");
	private By renderingLink=By.xpath("//a[contains(text(),'Example 2: Element rendered after the fact')]");
	public DynamicLoadingPage(WebDriver driver) {
		this.driver=driver;
	}
	public DynamicHiddenPage hiddenClick()
	{
		driver.findElement(hiddenLink).click();
		return new DynamicHiddenPage(driver);
	}
	public DynamicRenderingPage renderingClick()
	{
		driver.findElement(renderingLink).click();
		return new DynamicRenderingPage(driver);
	}
}
