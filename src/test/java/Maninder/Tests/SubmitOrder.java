package Maninder.Tests;

import main.pageobjects.Cart;
import main.pageobjects.CheckOut;
import main.pageobjects.ProductCatalogue;
import java.io.IOException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Maninder.TestComponents.BaseTest;

public class SubmitOrder extends BaseTest{

	@Test(dataProvider="getData")
	public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException {
		
		//Login
		ProductCatalogue productcatalogue = login.loginApplication(input.get("email"), input.get("password"));	
		
		//ADDING PRODUCTS
		productcatalogue.addToCart(input.get("product1"));
		productcatalogue.addToCart(input.get("product2"));
		
		//GOING TO THE CART
		Cart cart = productcatalogue.goToCart();		
		Boolean match = cart.verifyProduct(input.get("product1"));
		Assert.assertTrue(match);
		Boolean match2 = cart.verifyProduct(input.get("product2"));
		Assert.assertTrue(match2);
		CheckOut checkout = cart.clickCheckOut();
		
		//CHECKOUT
		checkout.checkOut();
	}
	
	@DataProvider
	public Object[][] getData() {
		
		HashMap<String, String> map1 = new HashMap<String, String>();
		map1.put("email", "man@xyz.com");
		map1.put("password", "Test@123");
		map1.put("product1", "ZARA COAT 3");
		map1.put("product2", "ADIDAS ORIGINAL");
		
		HashMap<String, String> map2 = new HashMap<String, String>();
		map2.put("email", "man@xyz.com");
		map2.put("password", "Test@123");
		map2.put("product1", "IPHONE 13 PRO");
		map2.put("product2", "ZARA COAT 3");
		
		return new Object[][] {{map1},{map2}};
		
	}
	
}
