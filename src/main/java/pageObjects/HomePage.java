package pageObjects;

import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import componentHelper.ClickHelper;
import componentHelper.TextBoxHelper;
import util.Browser;
import util.ElementUtil;
import util.GenericObjects;

public class HomePage {
	
	private WebDriver driver;
	GenericObjects GO= new GenericObjects();
	ElementUtil EU = new ElementUtil();
	@FindBy(xpath="//div[@class='province-dropdown'])[1]//span")
	private WebElement selectProvince;
	
	@FindBy(xpath="//div[text()='Featured']/parent::div/following-sibling::div[@class='v-input__append-inner']")
	private WebElement sorting;
	
	@FindBy(xpath="//div[@class='vehicle-card']")
	private List<WebElement> vehiclesList;
	@FindBy(xpath="//button[contains(@class,'heartIcon')]")
	private WebElement heartIcon;
	@FindBy(xpath="//div[contains(text(),'Calculate Delivery')]")
	private WebElement calcDelivery;
	@FindBy(xpath="//input[@id='street_address']")
	private WebElement address;
	@FindBy(xpath="(//div[@class='pca pcalist'])[1]")
	private WebElement selectAddress;
	@FindBy(xpath="//span[contains(text(),'Save and Confirm')]")
	private WebElement saveAndCnfrmBtn;
	@FindBy(xpath="//div[contains(text(),'Edit Delivery')]")
	private WebElement editDelivery;
	@FindBy(xpath="//div[contains(text(),'Select Warranty')]")
	private WebElement selectWarranty;
	public HomePage(WebDriver driver) {
        this.driver=driver;
    }
    
    public void fillCarSelectionInformation(String Province, String Brand, String Model, 
    		String SortingMechanism, String count, String deliveryAddress, String warrantyMonths) throws InterruptedException {
    	
    	ClickHelper.clickLink(GO.divClassSpan("province-dropdown", "1"));
    	Browser.getLogger().log(Status.INFO, "Provice dropdown was clicked");
    	ClickHelper.clickLink(GO.textLiFromUl(Province, "1"));
    	Browser.getLogger().log(Status.INFO, "Selected the desired province from dropdown");
    	ClickHelper.clickLink(GO.textSpan("Make & Model"));
    	Browser.getLogger().log(Status.INFO, "Selected Car Maker from the list");
    	EU.scrollToItem(Brand);
    	EU.waitFor(3000);
    	EU.elementToBeVisibleWait(GO.textSpan(Brand));
    	ClickHelper.clickLink(GO.textSpan(Brand));
    	Browser.getLogger().log(Status.INFO, "Brand was clicked");
    	EU.waitFor(3000);
    	EU.elementToBeVisibleWait(GO.textSpan(Model));
    	ClickHelper.clickLink(GO.textSpan(Model));
    	Browser.getLogger().log(Status.INFO, "Model was clicked");
    	EU.waitFor(3000);
    	EU.scrollUp();
    	ClickHelper.clickLink(GO.divClass("v-select__slot", "1"));
    	ClickHelper.clickLink(GO.textDiv(SortingMechanism,"1"));
    	Browser.getLogger().log(Status.INFO, "Applied the sorting technique");
    	EU.elementToBeVisibleWait(GO.divClass("vehicle-card", "1"));
    	EU.waitFor(3000);
    	for(int i=1;i<=Integer.parseInt(count);i++) {
    		ClickHelper.clickLink(GO.spanClass("heart", String.valueOf(i)));
    		Browser.getLogger().log(Status.INFO, "Cliked on Heart symbol for car " + String.valueOf(i));
    		EU.waitFor(1000);
    	}
    		ClickHelper.clickLink(GO.divClass("vehicle-card", "1"));
    		Browser.getLogger().log(Status.INFO, "Selected the desired car from the list to purchase");
    		EU.waitFor(1000);
    		EU.elementToBePresentWait(GO.textContainsSpan("Start Purchase", "3"));
    		ClickHelper.clickLink(GO.textContainsSpan("Start Purchase", "3"));
    		Browser.getLogger().log(Status.INFO, "Start Purchase button was clicked");
    		EU.elementToBePresentWait(GO.divContainsTxt("Calculate Delivery"));
    		ClickHelper.clickLink(GO.divContainsTxt("Calculate Delivery"));
    		Browser.getLogger().log(Status.INFO, "Calculate Delivery was clicked");
    		EU.elementToBePresentWait(GO.inputId("street_address"));
    		Browser.getLogger().log(Status.PASS,"Enter Delivery address page is opened");
    		EU.waitFor(1000);
    		
    }
    public void fillDeliveryInformation(String deliveryAddress, String warrantyMonths, String expectedWarrentyAmnt) throws InterruptedException {
    	ClickHelper.clickLink(GO.inputId("street_address"));
    	TextBoxHelper.typeInTextBox(GO.inputId("street_address"), deliveryAddress);
    	Browser.getLogger().log(Status.INFO, "Adress entered was " + deliveryAddress);
    	TextBoxHelper.typeInTextBox(GO.inputId("street_address"), Keys.SPACE);
    	TextBoxHelper.typeInTextBox(GO.inputId("street_address"),Keys.BACK_SPACE);
    	EU.waitFor(2000);
		EU.elementToBePresentWait(GO.divClass("pca pcalist", "1"));
		ClickHelper.clickLink(GO.divClass("pca pcalist", "1"));
		EU.waitFor(3000);
		EU.elementToBePresentWait(GO.textContainsSpan("Save and Confirm"));
		Browser.getLogger().log(Status.INFO, "Save and Confirm was clicked");
		EU.scrollToItem(GO.textContainsSpan("Save and Confirm"));
		EU.clickUsingJS(GO.textContainsSpan("Save and Confirm"));
		EU.elementToBePresentWait(GO.divContainsTxt("Edit Delivery"));
		Browser.getLogger().log(Status.PASS,"Calculate Delivery was changed to Edit delivery after address addition");
		ClickHelper.clickLink(GO.divContainsTxt("Select Warranty"));
		EU.elementToBePresentWait(GO.divContainsTxt("Protect Your Purchase"));
		EU.scrollToItem(GO.divContainsTxt(warrantyMonths));
		EU.elementToBePresentWait(GO.divContainsTxt(warrantyMonths));
		ClickHelper.clickLink(GO.divContainsTxt(warrantyMonths));
		Browser.getLogger().log(Status.INFO,"Warrenty Months was clicked" + warrantyMonths);
		ClickHelper.clickLink(GO.textContainsSpan("Save and Confirm","2"));
		Browser.getLogger().log(Status.INFO,"Save and Confirm the delivery and warranty");
		String actualAmount=driver.findElement(GO.divContainsSpanTxt("Warranty Plan")).getText().trim();
		Assert.assertEquals(actualAmount, expectedWarrentyAmnt);
		Browser.getLogger().log(Status.PASS,"Warranty amount populated for 48 months is expected");
		
    }
    
}
