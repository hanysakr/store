package com.adib.assessment.policy;

import com.adib.assessment.model.items.GroceryItem;
import com.adib.assessment.model.items.RegularItem;
import com.adib.assessment.model.users.User;

public interface ItemDiscountPolicy {

	public double visit(GroceryItem groceryItem, User user);
	public double visit(RegularItem regularItem, User user);	

}
