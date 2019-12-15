package oracle;

import org.testng.annotations.Test;

import tests.TestBase;

public class OracleTest extends TestBase {

	@Test
	public void copyErrorTest()
	{
		oraclePage.loginToTaleo();
		oraclePage.redirectingToSavedSearchesTab();
		oraclePage.errorchecking();
		oraclePage.createFolder();
	}
}
