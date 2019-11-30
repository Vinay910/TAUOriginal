package horizontalSlider;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import tests.TestBase;

public class HorizontalSliderTest extends TestBase{

	@Test
	public void validateHorizontalSlider()
	{
		horizontalSliderPage=homepage.clickHorizontalSliderLink();
		String result=horizontalSliderPage.ValidateSlider(Keys.chord(Keys.ARROW_RIGHT,Keys.ARROW_RIGHT,Keys.ARROW_RIGHT,Keys.ARROW_RIGHT));
		sf.assertTrue(result.contains("2"),"Invalid value");
	}
}
