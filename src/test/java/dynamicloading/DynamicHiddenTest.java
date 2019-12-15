package dynamicloading;

import org.testng.annotations.Test;

import tests.TestBase;

public class DynamicHiddenTest extends TestBase{
	@Test
	public void verifyDynamicLoad()
	{
		dynamicLoadingPage=homepage.dynamicLoadingLink();
		dynamicHiddenPage=dynamicLoadingPage.hiddenClick();
		sf.assertTrue(dynamicHiddenPage.clickAndValidate().contains("Hello"),"Invalid value returned");
		sf.assertAll();
		
	}
}
