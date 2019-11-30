package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage {
	
	WebDriver driver;
	private By HiddenLink=By.xpath("//a[contains(text(),'Example 1: Element on page that is hidden')]");
	private By RenderingLink=By.xpath("//a[contains(text(),'Example 2: Element rendered after the fact')]");
	public DynamicLoadingPage(WebDriver driver) {
		this.driver=driver;
	}
	public DynamicHiddenPage HiddenClick()
	{
		driver.findElement(HiddenLink).click();
		return new DynamicHiddenPage(driver);
	}
	public DynamicRenderingPage RenderingClick()
	{
		driver.findElement(RenderingLink).click();
		return new DynamicRenderingPage(driver);
	}
}
