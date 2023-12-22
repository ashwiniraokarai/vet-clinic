package serenitylabs.tutorials.vetclinic.sales;

import serenitylabs.tutorials.vetclinic.sales.model.LineItem;

public interface TaxRateType {
    TaxRate rateFor(LineItem item);
}
