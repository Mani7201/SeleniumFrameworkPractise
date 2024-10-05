package main.pageobjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class Cart extends AbstractComponent {
	
	WebDriver driver;
	
	public Cart(WebDriver driver) {
		super(driver);
		this.driver = driver ;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css=".cart h3")
	List<WebElement> productlist;	
	
	@FindBy(css=".totalRow button")
	WebElement checkoutbtn;

	public Boolean verifyProduct(String productName) {
		Boolean match = productlist.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productName));
		if(match == true)System.out.println("Product added in the cart");
		else System.out.println("Product NOT added in the cart");
		return match;
	}
	
	public CheckOut clickCheckOut() {
		checkoutbtn.click();
		CheckOut checkout = new CheckOut(driver);
		return checkout;
	}

	
	

}
