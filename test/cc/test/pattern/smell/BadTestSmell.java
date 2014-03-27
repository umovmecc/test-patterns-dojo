package cc.test.pattern.smell;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import cc.test.pattern.model.Address;
import cc.test.pattern.model.Customer;
import cc.test.pattern.model.Invoice;
import cc.test.pattern.model.InvoiceItem;
import cc.test.pattern.model.Product;

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

				// check billing
				assertTrue("billed", invoice.bill());

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

	@Test
	@Ignore
	public void shouldThrowBusinessExceptionWhenBillingANewInvoiceOnceThereIsNoProductsToProcess() {


	}

}
