package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavaScriptAlertPage {
	
	private WebDriver driver;
	private By alertAccept=By.xpath("//button[contains(text(),'Click for JS Alert')]");
	private By alertDismiss=By.xpath("//button[contains(text(),'Click for JS Confirm')]");
	private By alertSubmit=By.xpath("//button[contains(text(),'Click for JS Prompt')]");
	private By result=By.xpath("//p[@id='result']");		
	public JavaScriptAlertPage(WebDriver driver) {
		this.driver=driver;
	}
	private void trigger(By value)
	{
		driver.findElement(value).click();
	}
	public String alertClickAccept()
	{
		trigger(alertAccept);
		driver.switchTo().alert().accept();
		return driver.findElement(result).getText();
	}
	public String alertClickCancel()
	{
		trigger(alertDismiss);
		driver.switchTo().alert().dismiss();
		return driver.findElement(result).getText();
	}
	public String alertClickCancelTextVerification()
	{
		trigger(alertDismiss);
		String value=driver.switchTo().alert().getText();
		driver.switchTo().alert().dismiss();
		return value;
	}
	public String alertInputData(String value)
	{
		trigger(alertSubmit);
		driver.switchTo().alert().sendKeys(value);
		driver.switchTo().alert().accept();
		return driver.findElement(result).getText();
	}
	
	

	
}
