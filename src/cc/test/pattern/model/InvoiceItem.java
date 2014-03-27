package cc.test.pattern.model;

import java.math.BigDecimal;

public class InvoiceItem {

	private final Product product;
	private final Integer quantity;
	private final Invoice invoice;
	private final BigDecimal percentDiscount;

	public InvoiceItem(Invoice invoice, Product product, Integer quantity, BigDecimal percentDiscount) {
		this.invoice = invoice;
		this.product = product;
		this.quantity = quantity;
		this.percentDiscount = percentDiscount;
	}

	public Product getProduct() {
		return product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public BigDecimal getPercentDiscount() {
		return percentDiscount;
	}

}
