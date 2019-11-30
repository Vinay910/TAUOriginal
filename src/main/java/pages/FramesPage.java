package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesPage {
	
	WebDriver driver;
	private By nestedFrames=By.xpath("//a[contains(text(),'Nested Frames')]");
	//private By iFrames=By.xpath("//a[contains(text(),'iFrame')]");
	public FramesPage(WebDriver driver) {
		this.driver=driver;
	}
	public NestedFramePage nestedLinkClick()
	{
		driver.findElement(nestedFrames).click();
		return new NestedFramePage(driver);
	}
	

}
