package com.adib.assessment.policy.impl;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.adib.assessment.model.users.User;
import com.adib.assessment.policy.DiscountPolicy;
import com.adib.assessment.policy.ItemDiscountPolicy;
import com.adib.assessment.policy.ItemElement;

public class FirstDiscountPolicy implements DiscountPolicy {
	
	private static final int QUOTIENT_BASE = 100;
	private static final int QUOTIENT_DISCOUNT = 5;
	
	private ItemDiscountPolicy visitor;
	
	public FirstDiscountPolicy(){
		 this.visitor = new ItemDiscountPolicyImpl();
	}

	@Override
	public double calcItemsDiscount(List<ItemElement> items, User user) {
		if(Objects.isNull(items))
			return 0;
		
		return items.stream()
				.map(item -> item.applyDiscount(visitor, user))
				.collect(Collectors.summingDouble(e -> e));
	}

	@Override
	public double calcBillDiscount(List<ItemElement> items) {
		if(Objects.isNull(items))
			return 0;
		
		int quotient = (int) (items.stream().collect(Collectors.summingDouble(ItemElement::getItemPrice))
				/ QUOTIENT_BASE);
		return QUOTIENT_DISCOUNT * quotient;
	}
	

}
