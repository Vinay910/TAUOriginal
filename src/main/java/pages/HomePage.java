package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	private WebDriver driver;
    private void Authclick(String link)
    {
    	driver.findElement(By.xpath(link)).click();
    }
    public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	public LoginPage clickingAuthenticationLink()
	{
	    Authclick("//a[contains(text(),'Form Authentication')]");
		return new LoginPage(driver);
	}
    public DropDownPage clickingDropDownLink()
    {
    	Authclick("//a[contains(text(),'Dropdown')]");
    	return new DropDownPage(driver);
    }
    public ForgotPasswordPage clickingForgotPassword()
    {
    	Authclick("//a[contains(text(),'Forgot Password')]");
    	return new ForgotPasswordPage(driver);
    }
    public HoverOverPage clickHoverOver()
    {
    	Authclick("//a[contains(text(),'Hovers')]");
    	return new HoverOverPage(driver);
    }
    public KeysPressesPage clickKeyPress()
    {
    	Authclick("//a[contains(text(),'Key Presses')]");
    	return new KeysPressesPage(driver);
    }
    public HorizontalSliderPage clickHorizontalSliderLink()
    {
    	Authclick("//a[contains(text(),'Horizontal Slider')]");
    	return new  HorizontalSliderPage(driver);
    }
    public JavaScriptAlertPage clickJavaScriptAlert()
    {
    	Authclick("//a[contains(text(),'JavaScript Alerts')]");
    	return new JavaScriptAlertPage(driver);
    }
    public FileUploadPage clickFileUpload()
    {
    	Authclick("//a[contains(text(),'File Upload')]");
    	return new FileUploadPage(driver);
    }
    public WYSIWYNGPage clickWYSIWYNGLink()
    {
    	Authclick("//a[contains(text(),'WYSIWYG Editor')]");
    	return new WYSIWYNGPage(driver);
    }
    public FramesPage clickFrameLink()
    {
    	Authclick("//li[22]//a[1]");
    	return new FramesPage(driver);
    }
    public DynamicLoadingPage DynamicLoadingLink()
    {
    	Authclick("//a[contains(text(),'Dynamic Loading')]");
    	return new DynamicLoadingPage(driver);
    }
    public InfiniteScrollPage clickingInfiniteScrollLink()
    {
    	Authclick("//a[contains(text(),'Infinite Scroll')]");
    	return new InfiniteScrollPage(driver);
    }
    public MultiplePage clickMultiplePage()
    {
    	Authclick("//a[contains(text(),'Multiple Windows')]");
    	return new MultiplePage(driver);
    }
}
