package cc.test.pattern.smell;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import cc.test.pattern.exception.BusinessException;
import cc.test.pattern.model.Address;
import cc.test.pattern.model.Customer;
import cc.test.pattern.model.Invoice;
import cc.test.pattern.model.InvoiceItem;
import cc.test.pattern.model.Product;
import cc.test.pattern.smell.fixture.CustomerFixture;
import cc.test.pattern.smell.fixture.InvoiceFixture;
import cc.test.pattern.smell.fixture.ProductFixture;

public class BadTestSmell {

	Address billingAddress = null;
	Address shippingAddress = null;
	Customer customer = null;
	Product product = null;
	Invoice invoice = null;

	@Test
	public void test() {

		try {
			// Create dependencies
			billingAddress = new Address("Rua Fernando de Noronha", "50", "Cachoeirinha", "Vista Alegre", "94955170");
			shippingAddress = new Address("Rua Rio Grande do Norote", "89", "Cachoeirinha", "Vista Alegre", "94955350");
			customer = new Customer(999, "Saraiva", "Mauricio", billingAddress, shippingAddress);
			product = new Product(888, "Microfone", new BigDecimal("19.99"));
			invoice = new Invoice(customer);

			// run
			invoice.addProduct(product, 5);

			// check
			List<InvoiceItem> products = invoice.getProducts();
			if (products.size() == 1) {
				InvoiceItem item = products.get(0);
				assertEquals("inv", invoice, item.getInvoice());
				assertEquals("prod", product, item.getProduct());
				assertEquals("quant", 5, item.getQuantity().longValue());
				assertEquals("discount", new BigDecimal("19.99"), item.getPercentDiscount());
				assertEquals("customer", customer, item.getInvoice().getCustomer());

			} else {
				assertTrue("Invoice should have 1 item", false);
			}
		} finally {
			invoice = null;
			product = null;
			customer = null;
			billingAddress = null;
			shippingAddress = null;
		}
	}

	@Test(expected = BusinessException.class)
	public void shouldThrowBusinessExceptionWhenBillingANewInvoiceOnceThereIsNoProductsToProcess() {
		customer = CustomerFixture.get().build();
		invoice = InvoiceFixture.get().withCustomer(customer).build();
		invoice.bill();
	}

	@Test
	public void shouldSuccessBillInvoice() {
		product = ProductFixture.get().build();
		Invoice invoice = InvoiceFixture.get().withProduct(product).build();
		assertTrue(invoice.bill());
	}

	@Test
	public void shouldCreateAInvoiceItemBasedOnProduct() {
		BigDecimal discount = new BigDecimal("19.99");
		Product product = ProductFixture.get().withPercentualDiscount(discount).build();
		Invoice invoice = InvoiceFixture.get().build();

		invoice.addProduct(product, 1);

		assertEquals(1, invoice.getProducts().size());
		InvoiceItem item = invoice.getProducts().get(0);

		assertEquals(invoice, item.getInvoice());
		assertEquals(product, item.getProduct());
		assertEquals(1, item.getQuantity().longValue());
		assertEquals(discount, item.getPercentDiscount());
		assertEquals(customer, item.getInvoice().getCustomer());

	}

}
