package com.adib.assessment.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.adib.assessment.model.users.User;
import com.adib.assessment.policy.DiscountPolicy;
import com.adib.assessment.policy.ItemElement;

public class ShoppingCart {
	
	private List<ItemElement> items;
	private User user;
	private DiscountPolicy discountPolicy;
	
	public ShoppingCart(List<ItemElement> items, User user, DiscountPolicy discountPolicy) {
		super();
		this.items = items;
		this.user = user;
		this.discountPolicy = discountPolicy;
	}
	
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
