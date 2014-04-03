package cc.test.pattern.smell.fixture;

import cc.test.pattern.model.Customer;

public class CustomerFixture {

	public static CustomerFixture get() {
		return new CustomerFixture();
	}

	private final Customer customer = new Customer();

	public Customer build() {
		return customer;
	}



}
