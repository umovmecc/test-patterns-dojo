package cc.test.pattern.model;

import java.util.ArrayList;
import java.util.List;

import cc.test.pattern.service.InvoiceService;

public class Invoice {

	private InvoiceService service;
	private Customer customer;
	private List<InvoiceItem> products;

	public Invoice(Customer customer) {
		this.customer = customer;
		this.products = new ArrayList<InvoiceItem>();
		this.service = new InvoiceService();
	}

	public Invoice() {

	}

	public void addProduct(Product product, Integer quantity) {
		products.add(new InvoiceItem(this, product, quantity, product.getPercentDiscount()));
	}

	public List<InvoiceItem> getProducts() {
		return products;
	}

	public Customer getCustomer() {
		return customer;
	}

	public boolean bill() {
		return service.doBill(this);
	}

}
