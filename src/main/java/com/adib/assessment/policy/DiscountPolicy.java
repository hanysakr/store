package com.adib.assessment.policy;

import java.util.List;

import com.adib.assessment.model.users.User;

public interface DiscountPolicy {

	double calcItemsDiscount(List<ItemElement> items, User user);
	
	double calcBillDiscount(List<ItemElement> items);

}
