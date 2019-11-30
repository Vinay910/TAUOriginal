package fileUpload;

import org.testng.annotations.Test;

import tests.TestBase;

public class FileUploadTest extends TestBase{
	
	@Test
	public void ValidateFileUpload()
	{
		fileUploadPage=homepage.clickFileUpload();
		sf.assertTrue(fileUploadPage.verifyFileUpload("C:/Users/vinmahaj/Desktop/this.bmp").contains("this.bmp"),"Invalid file uploaded");
		sf.assertAll();
	}

}
