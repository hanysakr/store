package com.adib.assessment.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.adib.assessment.model.users.User;
import com.adib.assessment.policy.DiscountPolicy;
import com.adib.assessment.policy.ItemElement;

/**
 * @author hanysakr
 * 
 * ShoppingCart holds the main shopping cart functionality.
 * Could be extended to add Item, Remove Item, etc..
 *
 */
public class ShoppingCart {
	
	/**
	 * The selected Items list
	 */
	private List<ItemElement> items;
	
	/**
	 * User who purchased the items
	 */
	private User user;
	/**
	 * Chosen discount policy during the promotion period.
	 */
	private DiscountPolicy discountPolicy;
	
	public ShoppingCart(List<ItemElement> items, User user, DiscountPolicy discountPolicy) {
		super();
		this.items = items;
		this.user = user;
		this.discountPolicy = discountPolicy;
	}
	
	/**
	 * @return double: The net bill amount after discount.
	 */
	public double calc(){
		if(Objects.isNull(items))
			return 0;
		
		if(Objects.isNull(user))
			throw new IllegalArgumentException("No user is exist");
		
		return items.stream().collect(Collectors.summingDouble(ItemElement::getItemPrice)) 
				- discountPolicy.calcItemsDiscount(items, user)
				- discountPolicy.calcBillDiscount(items);
	}
	
}
