package cc.test.pattern.model;

public class Address {

	private final String address;
	private final String number;
	private final String city;
	private final String neighborhood;
	private final String zipcode;

	public Address(String address, String number, String city, String neighborhood, String zipcode) {
		this.address = address;
		this.number = number;
		this.city = city;
		this.neighborhood = neighborhood;
		this.zipcode = zipcode;
	}

	public String getAddress() {
		return address;
	}

	public String getNumber() {
		return number;
	}

	public String getCity() {
		return city;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public String getZipcode() {
		return zipcode;
	}


}
