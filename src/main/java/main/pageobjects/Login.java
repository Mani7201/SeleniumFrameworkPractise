package main.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class Login extends AbstractComponent {

	WebDriver driver;
	
	public Login(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement loginbtn;
	
	@FindBy(xpath="//div[@role='alert']")
	WebElement errorMessage;
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");	
	}

	public ProductCatalogue loginApplication(String email,String password) {
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		loginbtn.click();
		ProductCatalogue productcatalogue = new ProductCatalogue(driver);
		return productcatalogue;
		
	}
	
	public String getErrorMessage() {
		waitForElementToAppear(errorMessage);
		return errorMessage.getText();
		
	}
	
}	
