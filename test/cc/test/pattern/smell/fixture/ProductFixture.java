package cc.test.pattern.smell.fixture;

import java.math.BigDecimal;

import cc.test.pattern.model.Product;

public class ProductFixture {
	private final Product product = new Product();

	public static ProductFixture get() {
		return new ProductFixture();
	}

	public Product build() {
		return product;
	}

	public ProductFixture withPercentualDiscount(BigDecimal discount) {
		this.product.setPercentualDiscount(discount);
		return this;
	}

}
