package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WYSIWYNGPage {
	
	private WebDriver driver;
	private By childFrame=By.id("mce_0_ifr");
	private By childTextArea=By.xpath("//body[@id='tinymce']");
	private By indentingButton=By.xpath("//div[@id='mceu_12']//button");
	public WYSIWYNGPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void clearFrame()
	{
		switchToChildFrame();
		driver.findElement(childTextArea).clear();
		switchToMainFrame();
	}
	public void EnterData(String value)
	{
		switchToChildFrame();
		driver.findElement(childTextArea).sendKeys(value);
		switchToMainFrame();
	}
	public void clickIndenting()
	{
		driver.findElement(indentingButton).click();
	}
	private void switchToChildFrame()
	{
		driver.switchTo().frame(driver.findElement(childFrame));
	}
	private void switchToMainFrame()
	{
		driver.switchTo().parentFrame();
	}

}
