package dynamicLoading;

import org.testng.annotations.Test;

import tests.TestBase;

public class DynamicHiddenTest extends TestBase{
	@Test
	public void verifyDynamicLoad()
	{
		dynamicLoadingPage=homepage.DynamicLoadingLink();
		dynamicHiddenPage=dynamicLoadingPage.HiddenClick();
		sf.assertTrue(dynamicHiddenPage.clickAndValidate().contains("Hello"),"Invalid value returned");
		sf.assertAll();
		
	}
}
