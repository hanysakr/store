package com.adib.assessment.service;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.adib.assessment.model.items.GroceryItem;
import com.adib.assessment.model.items.RegularItem;
import com.adib.assessment.model.users.Affiliate;
import com.adib.assessment.model.users.Customer;
import com.adib.assessment.model.users.Employee;
import com.adib.assessment.model.users.User;
import com.adib.assessment.policy.DiscountPolicy;
import com.adib.assessment.policy.ItemElement;
import com.adib.assessment.policy.impl.FirstDiscountPolicy;

public class ShoppingCartTest {
	
	User employee;
	User newCustomer;
	User oldCustomer;
	User affiliate;
	
	List<ItemElement> items;
	DiscountPolicy discountPolicy;
	
	@Before
	public void setUp() throws Exception {
		employee = new Employee("Hany", "Sakr");
		newCustomer = new Customer("NewCustomer", "Salem", 1);
		oldCustomer = new Customer("OldCustomer", "Scott", 3);
		affiliate = new Affiliate("John", "Z");
		
		items = Arrays.asList(new ItemElement[]{
				new RegularItem("ITEM1",100),
				new RegularItem("ITEM2",20),
				new GroceryItem("GROCERY1", 30)
		});
		
		discountPolicy = new FirstDiscountPolicy();
	}

	@Test
	public void testEmplyee() {
		ShoppingCart shoppingCart = new ShoppingCart(items, employee, discountPolicy);
		items.stream().forEach(System.out::println);
		double net = shoppingCart.calc();
		assertEquals(109, net, 0);
	}
	
	@Test
	public void testOldCustomer() {
		ShoppingCart shoppingCart = new ShoppingCart(items, oldCustomer, discountPolicy);
		items.stream().forEach(System.out::println);
		double net = shoppingCart.calc();
		assertEquals(139, net, 0);
	}
	
	@Test
	public void testNewCustomer() {
		ShoppingCart shoppingCart = new ShoppingCart(items, newCustomer, discountPolicy);
		items.stream().forEach(System.out::println);
		double net = shoppingCart.calc();
		assertEquals(145, net, 0);
	}
	
	@Test
	public void testAffiliate() {
		ShoppingCart shoppingCart = new ShoppingCart(items, affiliate, discountPolicy);
		items.stream().forEach(System.out::println);
		double net = shoppingCart.calc();
		assertEquals(133, net, 0);
	}
	
	@Test
	public void testNoItems() {
		ShoppingCart shoppingCart = new ShoppingCart(null, affiliate, discountPolicy);
		items.stream().forEach(System.out::println);
		double net = shoppingCart.calc();
		assertEquals(0, net, 0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testNoUser() {
		ShoppingCart shoppingCart = new ShoppingCart(items, null, discountPolicy);
		items.stream().forEach(System.out::println);
		double net = shoppingCart.calc();
		assertEquals(0, net, 0);
	}

}
