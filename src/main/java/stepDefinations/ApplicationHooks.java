package stepDefinations;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import util.Browser;
import util.ConfigurationReader;

public class ApplicationHooks {

	private Browser driverFactory;
	private WebDriver driver;
	private ExtentTest logger;
	private ConfigurationReader configReader;
	Properties prop;
	
	@Before(order = 0)
	public void getProperty() {
		configReader = new ConfigurationReader();
		prop = configReader.init_prop();
	}

	@Before(order = 1)
	public void launchBrowser() {
		String browserName = prop.getProperty("driverType");
		String driverManager=prop.getProperty("driverManager");
		driverFactory = new Browser();
		driver = driverFactory.launchBrowser(browserName,driverManager);
		logger=driverFactory.setLogger();
	}

	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}

	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			// take screenshot:
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);

		}
	}

}
