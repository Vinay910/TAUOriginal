package infinteScroll;

import org.testng.annotations.Test;

import tests.TestBase;

public class InfiniteScrollTest extends TestBase{
	
	@Test
	public void validateInfiteScroll()
	{
		infiniteScrollPage=homepage.clickingInfiniteScrollLink();
		infiniteScrollPage.ScrollTo();
	}

}
