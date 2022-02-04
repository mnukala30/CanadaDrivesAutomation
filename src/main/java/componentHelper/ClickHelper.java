package componentHelper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ClickHelper {
	
	private static WebElement element;

    public static void clickLink(By Locator)
    {
        element = GenericHelper.GetElement(Locator);
        element.click();
    }
}
