package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicRenderingPage {

	WebDriver driver;
	private By startButton=By.xpath("//button[contains(text(),'Start')]");
	private By stringText=By.xpath("//h4[contains(text(),'Hello World!')]");
	public DynamicRenderingPage(WebDriver driver) {
		this.driver=driver;
	}
	public String validateDynamicRendering()
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		driver.findElement(startButton).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(stringText));
		return driver.findElement(stringText).getText();
	}

}
