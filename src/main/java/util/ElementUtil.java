package util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	GenericObjects GO= new GenericObjects();
	WebDriverWait wait;
	public void scrollToItem(String ele) {
		WebElement element=Browser.getDriver().findElement(GO.textSpan(ele));
		((JavascriptExecutor)Browser.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	public void scrollToItem(By ele) {
		WebElement element=Browser.getDriver().findElement(ele);
		((JavascriptExecutor)Browser.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	public void scrollDown() {
		((JavascriptExecutor)Browser.getDriver()).executeScript("window.scrollBy(0,350)", "");
	}
	public void scrollUp() {
		((JavascriptExecutor)Browser.getDriver()).executeScript("window.scrollBy(0,-350)", "");
	}
	public void elementToBeVisibleWait(By ele) {
		wait=new WebDriverWait(Browser.getDriver(), 30);
		wait.until(ExpectedConditions.visibilityOf(Browser.getDriver().findElement(ele)));
	}
	public void elementToBePresentWait(By ele) {
		wait=new WebDriverWait(Browser.getDriver(), 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(ele));
	}
	public void elementsToBeVisibleWait(List<WebElement> vehiclesList) {
		wait=new WebDriverWait(Browser.getDriver(), 30);
		wait.until(ExpectedConditions.visibilityOfAllElements(vehiclesList));
		
	}
	public void elementToBeVisibleWait(WebElement ele) {
		wait=new WebDriverWait(Browser.getDriver(), 30);
		wait.until(ExpectedConditions.visibilityOf(ele));
		
	}
	public void clickUsingJS(WebElement ele) {
		((JavascriptExecutor) Browser.getDriver()).executeScript("arguments[0].click();", ele);
	}
	public void clickUsingJS(By ele) {
		
		((JavascriptExecutor) Browser.getDriver()).executeScript("arguments[0].click();", Browser.getDriver().findElement(ele));
	}
	public void waitFor(long timeout) throws InterruptedException{
		Thread.sleep(timeout);
	}
}
