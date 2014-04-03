package cc.test.pattern.smell.fixture;

import cc.test.pattern.model.Product;

public class ProductFixture {
	private final Product product = new Product();

	public static ProductFixture get() {
		return new ProductFixture();
	}

	public Product build() {
		return product;
	}

}
