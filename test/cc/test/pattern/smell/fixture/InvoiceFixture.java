package cc.test.pattern.smell.fixture;

import cc.test.pattern.model.Customer;
import cc.test.pattern.model.Invoice;

public class InvoiceFixture {

	private final Invoice invoice = new Invoice();

	public static InvoiceFixture get() {
		return new InvoiceFixture();
	}

	public Invoice build() {
		return invoice;
	}

	public InvoiceFixture withCustomer(Customer customer) {
		this.invoice.setCustomer(customer);
		return this;
	}

}
