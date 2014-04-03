package cc.test.pattern.model;


public class Customer {

	private int id;
	private String name;
	private String midleName;
	private Address billingAddress;
	private Address shippingAddress;

	public Customer(int id, String name, String midleName, Address billingAddress, Address shippingAddress) {
		this.id = id;
		this.name = name;
		this.midleName = midleName;
		this.billingAddress = billingAddress;
		this.shippingAddress = shippingAddress;
	}

	public Customer() {
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
