package dynamicloading;

import org.testng.annotations.Test;

import tests.TestBase;

public class DynamicRenderingTest extends TestBase{

@Test	
public void validateDynamicRendering()
{
	dynamicLoadingPage=homepage.dynamicLoadingLink();
	dynamicRenderingPage=dynamicLoadingPage.renderingClick();
	sf.assertTrue(dynamicRenderingPage.validateDynamicRendering().contains("Hello"),"Invalid Text");
}
}
