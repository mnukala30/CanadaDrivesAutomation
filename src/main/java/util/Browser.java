package util;


import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Browser {

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	public static ThreadLocal<ExtentTest> logger = new ThreadLocal<>();
	public WebDriver driver;
	public ExtentReports report;
	public ExtentSparkReporter spark;
	public ExtentTest extentTest;
	public WebDriver launchBrowser(String browser, String driverManager) {

		if(driverManager.equals("true")) {
			
			switch (browser) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				tlDriver.set(new ChromeDriver());
				break;
			case "Firefox":
				WebDriverManager.firefoxdriver().setup();
				tlDriver.set(new FirefoxDriver());
				break;
			case "Edge":
				WebDriverManager.edgedriver().setup();
				tlDriver.set(new EdgeDriver());
				break;	
			default:
				break;
			}
		}else {
			switch (browser) {
			case "chrome":
				System.setProperty("webdriver.chrome.driver","Drivers\\chromedriver.exe");
				tlDriver.set(new ChromeDriver());
				break;
			case "Firefox":
				System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver.exe");
				tlDriver.set(new FirefoxDriver());
				break;
			case "Edge":
				System.setProperty("webdriver.edge.driver", ".\\Drivers\\EdgeDriver.exe");
				tlDriver.set(new EdgeDriver());
				break;	
			default:
				break;
			}
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
		
	}
	public ExtentTest setLogger() {
		spark=new ExtentSparkReporter(new File(System.getProperty("user.dir")+"/Reports/SparkReport/Spark.html"));
		report= new ExtentReports();
		report.attachReporter(spark);
		extentTest=report.createTest("Test Name");
		logger.set(extentTest);
		return getLogger();
	}
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
	public static synchronized ExtentTest getLogger() {
		return logger.get();
	}
	@AfterSuite
	public void tearDown() {
		report.flush();
	}
}
