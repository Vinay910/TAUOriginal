package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HorizontalSliderPage {
	
	private WebDriver driver;
	private By slider=By.xpath("//div[@class='sliderContainer']//input");
	private By result=By.xpath("//span[@id='range']");
	public HorizontalSliderPage(WebDriver driver) {
		this.driver=driver;
	}
	public String ValidateSlider(String value)
	{
		driver.findElement(slider).sendKeys(value);
		return driver.findElement(result).getText();
	}
	

}
