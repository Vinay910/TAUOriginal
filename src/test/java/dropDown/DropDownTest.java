package dropDown;

import java.util.List;

import org.testng.annotations.Test;

import tests.TestBase;

public class DropDownTest extends TestBase{
	
	@Test
	public void DropDownCheck()
	{
		dropDownPage=homepage.clickingDropDownLink();
		dropDownPage.selectOption("Option 1");
		List<String> ls=dropDownPage.displayAllSelected();
		sf.assertEquals(ls.size(), 1);
		sf.assertTrue(ls.contains("Option 1"), "Invalid value is present");
		sf.assertAll();
	}

}
