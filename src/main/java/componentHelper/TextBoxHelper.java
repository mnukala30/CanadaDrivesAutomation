package componentHelper;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import util.Browser;

public class TextBoxHelper {
	 private static WebElement element;
	 
     public static void typeInTextBox(By locator, String text)
     {
         element = GenericHelper.GetElement(locator);
         element.sendKeys(text);
     }
     public static void typeInTextBox(By locator, Keys keys)
     {
         element = GenericHelper.GetElement(locator);
         element.sendKeys(keys);
     }
     public static void clearTextBox(By locator)
     {
         element = GenericHelper.GetElement(locator);
         element.clear();
     }
    
}
