package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class InfiniteScrollPage {

	WebDriver driver;
	private int index=5;
	private By paragraph=By.xpath("//div[@class='jscroll-added']");
	public InfiniteScrollPage(WebDriver driver) {
		this.driver=driver;
	}
	public void scrollTo()
	{
		String script="window.scrollTo(0,document.body.scrollHeight)";
		JavascriptExecutor js=((JavascriptExecutor)driver);
		while(countParagraph()<index)
		{
			js.executeScript(script);
		}
	}
	private int countParagraph()
	{
		return driver.findElements(paragraph).size();
	}
	
}
