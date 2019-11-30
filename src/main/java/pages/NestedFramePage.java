package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFramePage {

	WebDriver driver;
	private By frameTop =By.name("frame-top");
	private By leftFrame=By.name("frame-left");
	private By leftText=By.xpath("//body[contains(text(),'LEFT')]");
	private By bottomFrame=By.name("frame-bottom");
	private By bottomText=By.xpath("//body[contains(text(),'BOTTOM')]");
	private String temp;
	public NestedFramePage(WebDriver driver) {
		this.driver=driver;
	}
	public String verifyLeftFrame()
	{	
		driver.switchTo().frame(driver.findElement(frameTop));	
		driver.switchTo().frame(driver.findElement(leftFrame));	
		temp = driver.findElement(leftText).getText();
		driver.switchTo().parentFrame();
		driver.switchTo().parentFrame();
		return temp;
	}
	public String verifyBottomFrame()
	{
		driver.switchTo().frame(driver.findElement(bottomFrame));	
		temp= driver.findElement(bottomText).getText();
		driver.switchTo().parentFrame();
		return temp;
	}
}
