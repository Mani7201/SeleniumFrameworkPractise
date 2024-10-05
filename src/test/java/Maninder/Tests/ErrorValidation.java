package Maninder.Tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import Maninder.TestComponents.BaseTest;
import main.pageobjects.Cart;
import main.pageobjects.ProductCatalogue;

public class ErrorValidation extends BaseTest{

	@Test
	public void LoginErrorValidation() throws IOException, InterruptedException {
		

		//Login ERROR Validation
		login.loginApplication("man@xyz.com", "Test@1234");
		Assert.assertEquals("Incorrect email or password.", login.getErrorMessage());

		
	}
	
	@Test
	public void CatalogueErrorValidation() throws IOException, InterruptedException {
		
		String firstProduct = "ZARA COAT 3";
		//Login ERROR Validation
		ProductCatalogue productcatalogue = login.loginApplication("man@xyz.com", "Test@123");
		//ADDING PRODUCTS
		productcatalogue.addToCart(firstProduct);
		
		//GOING TO THE CART
		Cart cart = productcatalogue.goToCart();		
		Boolean match = cart.verifyProduct("ZARA COAT 33");
		Assert.assertFalse(match);
	

		
	}
}
