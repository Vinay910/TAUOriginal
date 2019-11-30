package keyesPress;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import tests.TestBase;

public class KeysPressTest extends TestBase{
	
	@Test
	public void ValidateKeysPress()
	{
		keysPressesPage=homepage.clickKeyPress();
	    sf.assertTrue(keysPressesPage.enterTextAndVerify("My name is " +Keys.BACK_SPACE).contains("BACK_SPACE"),"Invalid keys entered");
	    sf.assertAll();
	}

}
