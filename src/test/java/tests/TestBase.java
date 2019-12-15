package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import com.google.common.io.Files;

import pages.DropDownPage;
import pages.DynamicHiddenPage;
import pages.DynamicLoadingPage;
import pages.DynamicRenderingPage;
import pages.EmailSentPage;
import pages.FileUploadPage;
import pages.ForgotPasswordPage;
import pages.FramesPage;
import pages.HomePage;
import pages.HorizontalSliderPage;
import pages.HoverOverPage;
import pages.HoverOverPage.FigureInner;
import pages.InfiniteScrollPage;
import pages.JavaScriptAlertPage;
import pages.KeysPressesPage;
import pages.LoginPage;
import pages.MultiplePage;
import pages.NestedFramePage;
import pages.OraclePage;
import pages.SuccessLoginPage;
import pages.WYSIWYNGPage;
import utils.EventReporter;
import utils.WindowNavigator;

public class TestBase {

	protected HomePage homepage;
	protected LoginPage loginPage;
	protected SuccessLoginPage successLoginPage;
	protected DropDownPage dropDownPage;
	protected ForgotPasswordPage forgotPasswordPage;
	protected EmailSentPage emailSentPage;
	protected HoverOverPage hoverOverPage;
	protected FigureInner figureInner;
	protected KeysPressesPage keysPressesPage;
	protected HorizontalSliderPage horizontalSliderPage;
	protected JavaScriptAlertPage javaScriptAlertPage;
	protected FileUploadPage fileUploadPage;
	protected WYSIWYNGPage wysiwyngPage;
	protected FramesPage framesPage;
	protected NestedFramePage nestedFramePage;
	protected DynamicLoadingPage dynamicLoadingPage;
	protected DynamicHiddenPage dynamicHiddenPage;
	protected DynamicRenderingPage dynamicRenderingPage;
	protected InfiniteScrollPage infiniteScrollPage;
	protected MultiplePage multiplePage;
	protected WindowNavigator windowNavigator;
	protected OraclePage oraclePage;
	protected SoftAssert sf;
	//private EventFiringWebDriver driver;
	protected Properties prop;
	protected DesiredCapabilities caps;
	private Process process;
	private String browserType;
	private WebDriver normalDriver;
	private String userPath;
	
	private void propLoad()
	{
		browserType=System.getProperty("browser_type");
		userPath=System.getProperty("user.dir");
		prop = System.getProperties();
		try {
			prop.load(new FileInputStream(new File(userPath+"/src/main/resources/Prop.properties")));
		} catch (Exception e) {
			e.getMessage();
		}
	}
	@BeforeSuite
	public void gridSetUp()
	{
		propLoad();
		if(prop.getProperty("grid").equalsIgnoreCase("yes"))
		{
			ProcessBuilder pb=new ProcessBuilder("cmd", "/c", "HubStart.bat");
			File dir = new File(userPath+"/src/main/resources");
			pb.directory(dir);
			try {
				process=pb.start();
			} catch (IOException e) {
				e.getMessage();
			}
		}
	}

	@BeforeClass
	public void setUp() throws MalformedURLException {
		caps=new DesiredCapabilities();
		propLoad();
		if (browserType.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", userPath+"/src/main/resources/chromedriver.exe");
			//driver = new EventFiringWebDriver(new ChromeDriver());
			normalDriver=new ChromeDriver();
		} else if (browserType.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", userPath+"/src/main/resources/geckodriver.exe");
			//driver = new EventFiringWebDriver(new FirefoxDriver());
			normalDriver=new FirefoxDriver();
		}
		else if(browserType.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", userPath+"/src/main/resources/IEDriverServer.exe");
			caps.setCapability("requireWindowFocus", true);  
			caps.setCapability("ignoreProtectedModeSettings", true);
			caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, false);
			//driver = new EventFiringWebDriver(new InternetExplorerDriver(caps));
			normalDriver=new InternetExplorerDriver(caps);
		}
		else if(browserType.equalsIgnoreCase("chromeremote"))
		{
			System.setProperty("webdriver.chrome.driver", userPath+"/src/main/resources/chromedriver.exe");
			caps=DesiredCapabilities.chrome();
			caps.setBrowserName("chrome");
			caps.setPlatform(Platform.LINUX);
			normalDriver=new RemoteWebDriver(new URL("http://localhost:4446/wd/hub"), caps);
		}
		//driver.register(new EventReporter());
		sf = new SoftAssert();
		goToHome();
		normalDriver.manage().window().maximize();
		normalDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//oraclePage= new OraclePage(normalDriver);
		homepage = new HomePage(normalDriver);
	}
	private void goToHome() {
		normalDriver.get(prop.getProperty("URL"));
	}

	@AfterClass
	public void tearDown() {
		Object[] win=normalDriver.getWindowHandles().toArray();
		for(int i=0;i<win.length;i++)
		{
			normalDriver.switchTo().window(win[i].toString());
			normalDriver.close();
		}
	}

	@AfterMethod
	public void captureFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
		
			TakesScreenshot camera = (TakesScreenshot) normalDriver;
			File file = camera.getScreenshotAs(OutputType.FILE);
			try {
				long time=System.currentTimeMillis();
				new File(userPath+"/src/main/java/screenshot/"+time).mkdir();
				Files.move(file, new File(
						userPath+"/src/main/java/screenshot/"+time+"/" + result.getName()+".jpg"));
			} catch (Exception e) {
				e.getMessage();
			}
		}
	}
	@AfterSuite
	public void gridDown()
	{
		process.destroy();
		process.destroyForcibly();
	}
}
