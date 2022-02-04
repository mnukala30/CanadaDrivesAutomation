package componentHelper;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import util.Browser;

public class GenericHelper {

	 public static WebElement GetElement(By locator)
     {
         if (IsElemetPresent(locator))
             return Browser.getDriver().findElement(locator);
         else
             throw new NoSuchElementException("Element Not Found : " + locator.toString());
     }
     public static Boolean IsElemetPresent(By locator)
     {
         try
         {
             return Browser.getDriver().findElements(locator).size() == 1;
         }
         catch (Exception e)
         {
             return false;
         }
         
     }
}
