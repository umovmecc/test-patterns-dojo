package cc.test.pattern.model;

import java.math.BigDecimal;

public class Product {

	private BigDecimal percentDiscount;
	private int id;
	private String description;

	public Product() {

	}

	public Product(int id, String description, BigDecimal percentDiscount) {
		this.id = id;
		this.description = description;
		this.percentDiscount = percentDiscount;
	}

	public String getDescription() {
		return description;
	}

	public BigDecimal getPercentDiscount() {
		return percentDiscount;
	}

	public int getId() {
		return id;
	}
}
