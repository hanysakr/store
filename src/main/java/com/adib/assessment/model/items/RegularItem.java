package com.adib.assessment.model.items;

import com.adib.assessment.model.users.User;
import com.adib.assessment.policy.ItemDiscountPolicy;
import com.adib.assessment.policy.ItemElement;

public class RegularItem extends Item implements ItemElement{

	public RegularItem(String name, double price) {
		super(name, price);
	}
	
	@Override
	public double applyDiscount(ItemDiscountPolicy visitor, User user) {
		return visitor.visit( this, user);
	}

	@Override
	public double getItemPrice() {
		return super.getPrice();
	}

}
