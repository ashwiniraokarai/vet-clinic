package serenitylabs.tutorials.vetclinic.sales;

import serenitylabs.tutorials.vetclinic.sales.model.LineItem;

public class StandardTaxAssessor implements TaxRateAssessor {
    @Override
    public TaxRate rateFor(LineItem item) {
        return new TaxRate(0.23, "Standard");
    }
}
