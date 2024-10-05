package main.pageobjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class CheckOut extends AbstractComponent {
	
	WebDriver driver;
	
	public CheckOut(WebDriver driver) {
		super(driver);
		this.driver = driver ;
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	@FindBy(xpath="(//div[contains(text(),'CVV')]//following::input[@class='input txt'])[1]")
	WebElement cvv;
	
	@FindBy(xpath="(//div[contains(text(),'CVV')]//following::input[@class='input txt'])[2]")
	WebElement name;
	
	@FindBy(xpath="//input[@name='coupon']")
	WebElement couponcode;
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement country;
	
	@FindBy(xpath="(//span[contains(text(),'India')])[2]")
	WebElement selectcountry;
	
	@FindBy(xpath="//a[contains(text(),'Place')]")
	WebElement placeorder;
	
	@FindBy(xpath="//h1[contains(text(),' Thankyou for the order. ')]")
	WebElement thankyoumessage;


	public void checkOut() throws IOException {
		cvv.sendKeys("123");
		name.sendKeys("XYZ MAN");
		couponcode.sendKeys("coupon code");
		country.sendKeys("India");
		selectcountry.click();
		placeorder.click();
		waitForElementToAppear(thankyoumessage);
		long now = System. currentTimeMillis();
		takeScreenShotofPage(now);
	}
	
	
	

}
