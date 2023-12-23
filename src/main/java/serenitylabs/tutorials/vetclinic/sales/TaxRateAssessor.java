package serenitylabs.tutorials.vetclinic.sales;

import serenitylabs.tutorials.vetclinic.sales.model.LineItem;

public interface TaxRateAssessor {
    TaxRate rateFor(LineItem item);
}
