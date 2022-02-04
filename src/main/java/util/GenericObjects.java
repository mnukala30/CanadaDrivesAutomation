package util;

import org.openqa.selenium.By;

public class GenericObjects {
	
	public By divClassSpan(String elementName, String linkNumber) {
		return By.xpath("(//div[@class='"+elementName+"'])["+linkNumber+"]//span");
	}
	public By textLi(String elementName, String linkNumber) {
		return By.xpath("(//li[contains(text(),'"+elementName+"')])["+linkNumber+"]");
	}
	public By textDiv(String textName) {
		return By.xpath("//div[text()='"+textName+"']");
	}
	public By textDiv(String textName, String linkNumber) {
		return By.xpath("(//div[text()='"+textName+"'])["+linkNumber+"]");
	}
	public By textSpan(String textName) {
		return By.xpath("//span[text()='"+textName+"']");
	}
	public By textLiFromUl(String elementName, String linkNumber) {
		return By.xpath("(//ul[@class='province-dropdown__list'])["+linkNumber+"]//li[contains(text(),'"+elementName+"')]");
	}
	public By checkBoxUsingSpan(String elementName) {
		return By.xpath("//span[text()='"+elementName+"']/ancestor::label/preceding-sibling::div//input[@role='checkbox']");
	}
	public By divClass(String className) {
		return By.xpath("//div[@class='"+className+"']");
	}
	public By divClass(String className,String linkNumber) {
		return By.xpath("(//div[@class='"+className+"'])["+linkNumber+"]");
	}
	public By textContainsSpan(String textName) {
		return By.xpath("//span[contains(.,'"+textName+"')]");
	}
	public By textContainsSpan(String textName, String linkNumber) {
		return By.xpath("(//span[contains(text(),'"+textName+"')])["+linkNumber+"]");
	}
	public By spanClass(String className, String linkNumber) {
		return By.xpath("(//span[contains(@class,'"+className+"')])["+linkNumber+"]");
	}
	public By divContainsTxt(String elementName) {
		return By.xpath("//div[contains(text(),'"+elementName+"')]");
	}
	public By divContainsTxtdiv(String elementName) {
		return By.xpath("//div[contains(text(),'"+elementName+"')]/following-sibling::div/text()");
	}
	public By divContainsSpanTxt(String elementName) {
		return By.xpath("//div[contains(text(),'"+elementName+"')]/parent::div/following-sibling::div//span");
	}
	public By inputId(String elementName) {
		return By.xpath("//input[@id='"+elementName+"']");
	}
	public By divTitle(String title,String linkNumber) {
		return By.xpath("(//div[@title'"+title+"'])["+linkNumber+"]");
	}
}
