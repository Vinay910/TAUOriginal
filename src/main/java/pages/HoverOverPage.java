package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HoverOverPage {
	
	private WebDriver driver;
	private By hoverAll=By.className("figure");
	public HoverOverPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	/**
	 * Index of a list starts with zero so if a user send a 1 he means to fetch object at zeroth 
	 * position of a list
	 * @param index
	 */
	public FigureInner hoverOver(int index)
	{
		Actions actions=new Actions(driver);
		WebElement figure=driver.findElements(hoverAll).get(index-1);
	    actions.moveToElement(figure).build().perform();
	    return new FigureInner(figure);
	}
	public class FigureInner
	{
		private WebElement figure;
		FigureInner(WebElement figure)
		{
			this.figure=figure;
		}
		private By heading=By.tagName("h5");
		private By link=By.tagName("a");
		
		public String validateHeading()
		{
			return figure.findElement(heading).getText();
		}
		public boolean validateLinkDisplayed()
		{
			return figure.findElement(link).isDisplayed();
		}
		public String validateLinkText()
		{
			return figure.findElement(link).getAttribute("href");
		}
		
	}
	
	

}
