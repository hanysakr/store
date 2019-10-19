package com.adib.assessment.model.users;

public abstract class User {
	
	protected String first;
	protected String last;
	
	public User(String first, String last) {
		super();
		this.first = first;
		this.last = last;
	}

	public String getFirst() {
		return first;
	}

	public String getLast() {
		return last;
	}

	@Override
	public String toString() {
		return "User [first=" + first + ", last=" + last + "]";
	}

	
}
