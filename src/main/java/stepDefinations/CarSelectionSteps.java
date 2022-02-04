package stepDefinations;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.github.dockerjava.api.model.LogConfig.LoggingType;

import util.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import util.Browser;
import util.ConfigurationReader;

public class CarSelectionSteps {

	private HomePage homePage = new HomePage(Browser.getDriver());
	ConfigurationReader CR = new ConfigurationReader();
	Properties Prop = CR.init_prop();

	@BeforeSuite
	public void setUpSuite() {
		Browser.getLogger().log(Status.INFO, "Test case started");
	}

	@Given("Open the browser and Launch the application")
	public void open_the_browser() {
		Browser.getLogger().log(Status.INFO, "Browser is launched successfully");
		Browser.getDriver().get(Prop.getProperty("url"));
		Browser.getLogger().log(Status.INFO, "Loaded with url " + Prop.getProperty("url"));
	}

	@When("User fills the form from given {string} and {int}")
	public void user_fills_the_form_from_given_and(String sheetName, Integer rowNumber)
			throws InvalidFormatException, IOException, InterruptedException {

		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testData = reader
				.getData(System.getProperty("user.dir") + Prop.getProperty("testDataPath"), sheetName);
		String Province = testData.get(rowNumber).get("Province");
		String Brand = testData.get(rowNumber).get("Brand");
		String Model = testData.get(rowNumber).get("Model");
		String SortingTechnique = testData.get(rowNumber).get("SortingTechnique");
		String Count = testData.get(rowNumber).get("Count");
		String Address = testData.get(rowNumber).get("Address");
		String WarrantyMonths = testData.get(rowNumber).get("WarrantyMonths");
		homePage.fillCarSelectionInformation(Province, Brand, Model, SortingTechnique, Count, Address, WarrantyMonths);
	}

	@When("User fills the address and warranty Months from given {string} and {int}")
	public void user_fills_the_address_and_warranty_months_from_given_and(String sheetName, Integer rowNumber)
			throws InvalidFormatException, IOException, InterruptedException {
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testData = reader
				.getData(System.getProperty("user.dir") + Prop.getProperty("testDataPath"), sheetName);
		String Address = testData.get(rowNumber).get("Address");
		String WarrantyMonths = testData.get(rowNumber).get("WarrantyMonths");
		String WarrantyAmount = testData.get(rowNumber).get("WarrantyAmount");
		homePage.fillDeliveryInformation(Address, WarrantyMonths, WarrantyAmount);
	}
}
