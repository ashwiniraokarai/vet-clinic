package serenitylabs.tutorials.vetclinic.sales;

import serenitylabs.tutorials.vetclinic.sales.model.LineItem;

public interface TaxRateType {
    public TaxRate rateFor(LineItem item);
}
