package com.adib.assessment.policy;

import java.util.List;

import com.adib.assessment.model.users.User;

/**
 * @author hanysakr
 * 
 * The Discount policy holds the types of discounts
 * Item level discount and bill level discount 
 *
 */
public interface DiscountPolicy {

	/**
	 * Calculate total items discount.
	 * 
	 * @param items List of items
	 * @param user depends on user type.
	 * @return the discount for all selected items.
	 */
	double calcItemsDiscount(List<ItemElement> items, User user);
	
	/**
	 * Calculate bill level discount policy
	 * 
	 * @param items List of items
	 * @return the bill discount
	 */
	double calcBillDiscount(List<ItemElement> items);

}
