package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownPage {
	
	WebDriver driver;
	private By dropDown=By.xpath("//select[@id='dropdown']");
	public DropDownPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void selectOption(String value)
	{
		intializingDropdown().selectByVisibleText(value);
	}
	public List<String> displayAllSelected()
	{
		List<WebElement> ls=intializingDropdown().getAllSelectedOptions();
		List<String> ls1=new ArrayList<String>();
		for(WebElement a:ls)
		{
			ls1.add(a.getText());
		}
		return ls1;
	}
	private Select intializingDropdown()
	{
		return new Select(driver.findElement(dropDown));
	}

}
