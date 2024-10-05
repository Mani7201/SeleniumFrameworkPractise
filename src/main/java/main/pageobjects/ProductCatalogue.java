package main.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {
	
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver ;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css=".card-body")
	List<WebElement> products;
	
	@FindBy(xpath="//div[@aria-label='Product Added To Cart']")
	WebElement addtocartsuccessmessage;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutbtn;
	
	@FindBy(xpath="(//button[contains(text(),'Cart')])[1]")
	WebElement gottocart;
	
	By addToCartBtn = By.xpath(".//button[@class='btn w-10 rounded']");
	
	public List<WebElement> getProductList() {
		waitForElementToAppearList(products);
		return products;		
	}
	
	public WebElement getProductName(String productName) {
		WebElement prod = getProductList().stream().filter(product->product.findElement(By.tagName("b")).getText().equalsIgnoreCase(productName)).findAny().orElse(null);		
		return prod;
	}
	
	public void addToCart(String productName) throws InterruptedException {
		WebElement prod = getProductName(productName);
		prod.findElement(addToCartBtn).click();	
		Thread.sleep(5000);
		System.out.println(prod.getText());
	}
	
	public Cart goToCart() {
		gottocart.click();
		waitForElementToAppear(checkoutbtn);
		Cart cart = new Cart(driver);
		return cart;
	}

}
