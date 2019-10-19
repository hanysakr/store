package com.adib.assessment.policy.impl;

import com.adib.assessment.model.items.GroceryItem;
import com.adib.assessment.model.items.RegularItem;
import com.adib.assessment.model.users.Affiliate;
import com.adib.assessment.model.users.Customer;
import com.adib.assessment.model.users.Employee;
import com.adib.assessment.model.users.User;
import com.adib.assessment.policy.ItemDiscountPolicy;

public class ItemDiscountPolicyImpl implements ItemDiscountPolicy {

	private static final int NO_DISCOUNT_VALUE = 0;
	private static final int CUSTOMER_SINCE_IN_YEARS = 2;
	private static final double CUSTOMER_PERCENTAGE_DISCOUNT = 0.05;
	private static final double AFFILIATE_PERCENTAGE_DISCOUNT = 0.10;
	private static final double EMPLOYEE_PERCENTAGE_DISCOUNT = 0.30;

	public double visit(GroceryItem groceryItem, User user) {
		return NO_DISCOUNT_VALUE;
	}

	public double visit(RegularItem regularItem, User user) {
		
		if (user instanceof Employee) {
			return regularItem.getPrice() * EMPLOYEE_PERCENTAGE_DISCOUNT;
			
		} else if (user instanceof Affiliate) {
			return regularItem.getPrice() * AFFILIATE_PERCENTAGE_DISCOUNT;
			
		} else if (user instanceof Customer) {
			if (((Customer) user).getCustomerSince() > CUSTOMER_SINCE_IN_YEARS) {
				return regularItem.getPrice() * CUSTOMER_PERCENTAGE_DISCOUNT;
			}
		}
		return NO_DISCOUNT_VALUE;
	}

}
