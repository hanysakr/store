package com.adib.assessment.model.users;

public class Customer extends User {
	
	private int customerSince;

	public Customer(String first, String last, int custmerSince) {
		super(first, last);
		this.customerSince = custmerSince;
	}

	public int getCustomerSince() {
		return customerSince;
	}

	@Override
	public String toString() {
		return "Customer [customerSince=" + customerSince + ", first=" + first + ", last=" + last + "]";
	}
	
	

}
