package com.adib.assessment.policy;

import com.adib.assessment.model.users.User;

public interface ItemElement {

	public double applyDiscount(ItemDiscountPolicy visitor, User user);
	
	public double getItemPrice();
}
