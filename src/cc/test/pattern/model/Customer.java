package cc.test.pattern.model;


public class Customer {

	private final int id;
	private final String name;
	private final String midleName;
	private final Address billingAddress;
	private final Address shippingAddress;

	public Customer(int id, String name, String midleName, Address billingAddress, Address shippingAddress) {
		this.id = id;
		this.name = name;
		this.midleName = midleName;
		this.billingAddress = billingAddress;
		this.shippingAddress = shippingAddress;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getMidleName() {
		return midleName;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}


}
