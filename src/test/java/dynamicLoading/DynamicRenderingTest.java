package dynamicLoading;

import org.testng.annotations.Test;

import tests.TestBase;

public class DynamicRenderingTest extends TestBase{

@Test	
public void validateDynamicRendering()
{
	dynamicLoadingPage=homepage.DynamicLoadingLink();
	dynamicRenderingPage=dynamicLoadingPage.RenderingClick();
	sf.assertTrue(dynamicRenderingPage.validateDynamicRendering().contains("Hello"),"Invalid Text");
}
}
