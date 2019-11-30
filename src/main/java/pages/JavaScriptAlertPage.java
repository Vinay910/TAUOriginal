package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavaScriptAlertPage {
	
	private WebDriver driver;
	private By alert_accept=By.xpath("//button[contains(text(),'Click for JS Alert')]");
	private By alert_Dismiss=By.xpath("//button[contains(text(),'Click for JS Confirm')]");
	private By alert_submit=By.xpath("//button[contains(text(),'Click for JS Prompt')]");
	private By result=By.xpath("//p[@id='result']");		
	public JavaScriptAlertPage(WebDriver driver) {
		this.driver=driver;
	}
	private void trigger(By value)
	{
		driver.findElement(value).click();
	}
	public String alert_clickAccept()
	{
		trigger(alert_accept);
		driver.switchTo().alert().accept();
		return driver.findElement(result).getText();
	}
	public String alert_clickCancel()
	{
		trigger(alert_Dismiss);
		driver.switchTo().alert().dismiss();
		return driver.findElement(result).getText();
	}
	public String alert_clickCancelTextVerification()
	{
		trigger(alert_Dismiss);
		String value=driver.switchTo().alert().getText();
		driver.switchTo().alert().dismiss();
		return value;
	}
	public String alert_InputData(String Value)
	{
		trigger(alert_submit);
		driver.switchTo().alert().sendKeys(Value);
		driver.switchTo().alert().accept();
		return driver.findElement(result).getText();
	}
	
	

	
}
