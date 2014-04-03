package cc.test.pattern.service;

import cc.test.pattern.exception.BusinessException;
import cc.test.pattern.model.Invoice;

public class InvoiceService {

	public boolean doBill(Invoice invoice) {
		if (invoice.getProducts().isEmpty())
			throw new BusinessException("No products found.");
		return true;
	}

}
