package com.adib.assessment.policy;

import com.adib.assessment.model.users.User;

/**
 * @author hanysakr
 * Item mandatory methods to be used by the visitor ItemDiscountPolicy
 *
 */
public interface ItemElement {

	/**
	 * @param visitor the itemDiscountPolicy visitor pattern
	 * @param user; The type of user
	 * @return the item discount.
	 */
	public double applyDiscount(ItemDiscountPolicy visitor, User user);
	
	/**
	 * @return the original item price.
	 */
	public double getItemPrice();
}
