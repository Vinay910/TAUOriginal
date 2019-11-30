package navigation;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import tests.TestBase;

public class NavigationTest extends TestBase {
	WebDriver driver;
	@Test
	public void navigationTest()
	{
	 multiplePage=homepage.clickMultiplePage();	
	 windowNavigator=multiplePage.clickhere();
	 windowNavigator=windowNavigator.switchWindow("New Window");
	}

}
